package calocheck.boundedContext.dailyMenu.service;

import calocheck.boundedContext.cartFoodInfo.entity.CartFoodInfo;
import calocheck.boundedContext.cartFoodInfo.service.CartFoodInfoService;
import calocheck.boundedContext.dailyMenu.entity.DailyMenu;
import calocheck.boundedContext.dailyMenu.repository.DailyMenuRepository;
import calocheck.boundedContext.foodInfo.entity.FoodInfo;
import calocheck.boundedContext.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

// MealHistory (DailyMenu, DailyMenu, DailyMenu)
@Service
@RequiredArgsConstructor
public class DailyMenuService {

    private final DailyMenuRepository dailyMenuRepository;
    private final CartFoodInfoService cartFoodInfoService;

    public DailyMenu create(Member member, FoodInfo foodInfo, Long quantity, String mealType, String mealMemo)

    @Transactional
    public List<DailyMenu> create(Member member, String mealType) {

        List<CartFoodInfo> cartByMember = cartFoodInfoService.findAllByMember(member);
        List<DailyMenu> dailyMenuList = new ArrayList<>();

        //식단을 추가하게 되면, 카트의 내용들 중 음식명과 양을 가져와서, 저장한다
        for (int i = 0; i < cartByMember.size(); i++) {

            DailyMenu dailyMenu = DailyMenu.builder()
                    .member(member)
                    .foodInfo(cartByMember.get(i).getFoodInfo())
                    .quantity(cartByMember.get(i).getQuantity())
                    .mealType(mealType)
                    .build();

            dailyMenuRepository.save(dailyMenu);
            dailyMenuList.add(dailyMenu);
        }

        return dailyMenuList;
    }

    @Transactional
    public void delete(DailyMenu dailyMenu) {
        dailyMenuRepository.delete(dailyMenu);
    }

    public DailyMenu findById(Long id) {
        Optional<DailyMenu> dailyMenu = dailyMenuRepository.findById(id);

        return dailyMenu.orElse(null);
    }

    @Transactional
    public void updateMealHistory(DailyMenu dailyMenu){

        dailyMenuRepository.save(dailyMenu);
    }

}
