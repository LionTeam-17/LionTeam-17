package calocheck.boundedContext.tracking.controller;

import calocheck.boundedContext.member.entity.Member;
import calocheck.boundedContext.member.service.MemberService;
import calocheck.boundedContext.tracking.entity.Tracking;
import calocheck.boundedContext.tracking.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class TrackingController {

    private final TrackingService trackingService;
    private final MemberService memberService; // Declare MemberService

    @Autowired
    public TrackingController(TrackingService trackingService, MemberService memberService) { // Inject MemberService
        this.trackingService = trackingService;
        this.memberService = memberService;
    }

    @GetMapping("/tracking/{memberId}")
    public String showTracking(@PathVariable("memberId") Long memberId, Model model, Principal principal) {
        Optional<Member> memberOptional = memberService.findById(memberId);
        String currentPrincipalName = principal.getName();
        Member currentMember = memberService.findByUsername(currentPrincipalName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + currentPrincipalName));

        if (!memberOptional.isPresent()) {
            //로그인을 했을 때만 접근 가능
            return "error/memberNotFound";
        }

        if (!currentMember.getId().equals(memberId)) {
            //본인의 아이디로 본인의 페이지만 접근가능
            return "error/unauthorized";
        }

        Member member = memberOptional.get();
        List<Tracking> trackingData = trackingService.findTrackingsByMember(member);
        model.addAttribute("trackingData", trackingData); // Add trackingData to the model
        model.addAttribute("tracking", new Tracking()); // Add an empty Tracking object to the model
        return "usr/tracking/bodyTracking";
    }

    @PostMapping("/tracking")
    public String createTracking(@ModelAttribute("tracking")
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") Tracking tracking,
                                 Principal principal) {
        // Retrieve the logged in member
        String currentPrincipalName = principal.getName();
        Member member = memberService.findByUsername(currentPrincipalName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + currentPrincipalName));

        // Set member in tracking data
        tracking.setMember(member);

        // Save tracking data
        Tracking createdTracking = trackingService.createTracking(
                member,
                tracking.getDateTime(),
                tracking.getWeight(),
                tracking.getBodyFat(),
                tracking.getMuscleMass()
        );

        // Redirect to tracking page
        return "redirect:/tracking/" + createdTracking.getMember().getId();
    }



}
