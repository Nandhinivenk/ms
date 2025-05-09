package com.cloudkitchen.fooditem_ms.controller;

import com.cloudkitchen.fooditem_ms.model.FoodItem;
import com.cloudkitchen.fooditem_ms.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        return ResponseEntity.ok(foodItemService.getFoodItemById(id));
    }

    // Other endpoints like POST, PUT, DELETE can go here
}
