package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.dto.FoodDto;
import com.usman.hostelmanagementsystem.model.Food;

import java.util.List;

public interface FoodService {

    void  saveFood(FoodDto food, long staffId);

    List<Food>  listTodayMeal();
}
