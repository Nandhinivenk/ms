package com.cloudkitchen.foodingredientmapping_ms.controller;

import com.cloudkitchen.foodingredientmapping_ms.model.FoodIngredientMapping;
import com.cloudkitchen.foodingredientmapping_ms.service.FoodIngredientMappingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-ingredients")
public class FoodIngredientMappingController {

    private final FoodIngredientMappingService mappingService;

    public FoodIngredientMappingController(FoodIngredientMappingService mappingService) {
        this.mappingService = mappingService;
    }

    @PostMapping
    public ResponseEntity<FoodIngredientMapping> addMapping(@RequestBody FoodIngredientMapping mapping) {
        return ResponseEntity.ok(mappingService.addMapping(mapping));
    }

    @GetMapping("/{foodItemId}")
    public ResponseEntity<List<FoodIngredientMapping>> getMappings(@PathVariable Long foodItemId) {
        return ResponseEntity.ok(mappingService.getMappingsForFoodItem(foodItemId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Long id) {
        mappingService.deleteMapping(id);
        return ResponseEntity.ok().build();
    }
}
