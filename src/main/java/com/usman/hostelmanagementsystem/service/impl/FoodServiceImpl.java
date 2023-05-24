package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.dto.FoodDto;
import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Food;
import com.usman.hostelmanagementsystem.model.Staff;
import com.usman.hostelmanagementsystem.repository.FoodRepository;
import com.usman.hostelmanagementsystem.service.FoodService;
import com.usman.hostelmanagementsystem.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private  final StaffService staffService;
    @Autowired
    private  final FoodRepository foodRepository;

    @Override
    public void saveFood(FoodDto food1, long staffId) {
        Food food = new Food();
        food.setMeals(food1.getMeal());
        Staff staff=staffService.getStaffById(staffId);
        if(ObjectUtils.isEmpty(food.getMeals().getBreakFast())){
            throw  new BusinessException("BREAKFAST CANT BE EMPTY");
        }

        if(ObjectUtils.isEmpty(food.getMeals().getLunch())){
            throw  new BusinessException("LUNCH CANT BE EMPTY");

        }

        if(ObjectUtils.isEmpty(food.getMeals().getSupper())){
            throw  new BusinessException("SUPPER CANT BE EMPTY");

        }

        foodRepository.deleteAll();
        food.setStaffId(staff);
        foodRepository.save(food);


    }

    @Override
    public List<Food> listTodayMeal() {
        return foodRepository.findAll();
    }


}
