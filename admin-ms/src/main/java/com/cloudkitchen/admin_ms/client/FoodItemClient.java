package com.cloudkitchen.admin_ms.client;

import com.cloudkitchen.admin_ms.dto.FoodItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "fooditem-ms")
public interface FoodItemClient {

    @GetMapping("/api/food-items")
    List<FoodItemDto> getAllFoodItems();

    @GetMapping("/api/food-items/{id}")
    FoodItemDto getFoodItemById(@PathVariable("id") Long id);

    @PostMapping("/api/food-items")
    FoodItemDto addFoodItem(@RequestBody FoodItemDto item);

    @PutMapping("/api/food-items/{id}")
    FoodItemDto updateFoodItem(@PathVariable("id") Long id, @RequestBody FoodItemDto item);

    @DeleteMapping("/api/food-items/{id}")
    void deleteFoodItem(@PathVariable("id") Long id);
}
