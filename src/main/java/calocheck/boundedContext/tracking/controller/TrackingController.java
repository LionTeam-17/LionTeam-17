package calocheck.boundedContext.tracking.controller;

import calocheck.base.rq.Rq;
import calocheck.boundedContext.member.entity.Member;
import calocheck.boundedContext.member.service.MemberService;
import calocheck.boundedContext.tracking.entity.Tracking;
import calocheck.boundedContext.tracking.service.TrackingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class TrackingController {
    private final TrackingService trackingService;
    private final MemberService memberService;
    private final Rq rq;

    @Autowired
    public TrackingController(Rq rq, TrackingService trackingService, MemberService memberService) {
            this.rq =rq;
            this.trackingService = trackingService;
            this.memberService = memberService;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tracking")
    public String showTracking(Model model) {
        Optional<Member> memberOptional = memberService.findById(rq.getMember().getId());

        if (!memberOptional.isPresent()) {
            return "error/memberNotFound";
        }

        Member member = memberOptional.get();
        List<Tracking> trackingData = trackingService.findTrackingsByMember(member);
        model.addAttribute("trackingData", trackingData);
        model.addAttribute("tracking", new Tracking());
        return "usr/tracking/bodyTracking";
    }
    @Transactional
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/tracking")
    public String createTracking(@ModelAttribute("tracking")
                                 @DateTimeFormat(pattern = "yyyy-MM-dd") Tracking tracking,
                                 Principal principal) {

        String currentPrincipalName = principal.getName();
        Member member = memberService.findByUsername(currentPrincipalName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + currentPrincipalName));

        tracking.setMember(member);
        tracking.setDateTime(LocalDate.now());

        if (tracking.getAge() == null) {
            tracking.setAge(member.getAge());
        }
        if (tracking.getHeight() == null) {
            tracking.setHeight(member.getHeight());
        }
        if (tracking.getWeight() == null) {
            tracking.setWeight(member.getWeight());
        }
        if (tracking.getBodyFat() == null) {
            tracking.setBodyFat(member.getBodyFat());
        }
        if (tracking.getMuscleMass() == null) {
            tracking.setMuscleMass(member.getMuscleMass());
        }

        // if no tracking exists for this date, set initial tracking data to member's registration data
        Optional<Tracking> existingTracking = trackingService.findByMemberAndDate(member, tracking.getDateTime());
        Tracking savedTracking;
        if (existingTracking.isPresent()) {
            Tracking trackingToUpdate = existingTracking.get();
            trackingToUpdate.setWeight(tracking.getWeight());
            trackingToUpdate.setBodyFat(tracking.getBodyFat());
            trackingToUpdate.setMuscleMass(tracking.getMuscleMass());

            savedTracking = trackingService.updateTracking(trackingToUpdate);
        } else {
            // set initial tracking data to member's registration data
            tracking.setWeight(member.getWeight());
            tracking.setBodyFat(member.getBodyFat());
            tracking.setMuscleMass(member.getMuscleMass());

            savedTracking = trackingService.createTracking(tracking);
        }

        return "redirect:/tracking";
    }


}
