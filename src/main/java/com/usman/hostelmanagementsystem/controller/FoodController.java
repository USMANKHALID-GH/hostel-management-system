package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.FoodDto;
import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.model.Food;
import com.usman.hostelmanagementsystem.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/food")
public class FoodController {

    private FoodService foodService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> saveFood(@RequestBody FoodDto foodDto , @RequestHeader("staffId") long staffId){

        foodService.saveFood(foodDto,staffId);
        return ResponseEntity.ok(ResponseDto.builder().message("food saved").build());
    }

}
