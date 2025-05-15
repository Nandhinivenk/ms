package com.cloudkitchen.admin_ms.client;

import com.cloudkitchen.admin_ms.dto.FoodIngredientMappingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "foodingredientmapping-ms")
public interface FoodIngredientMappingClient {

    @PostMapping("/api/food-ingredients")
    FoodIngredientMappingDto addMapping(@RequestBody FoodIngredientMappingDto mappingDto);

    @GetMapping("/api/food-ingredients/{foodItemId}")
    List<FoodIngredientMappingDto> getMappingsByFoodItem(@PathVariable("foodItemId") Long foodItemId);

    @PutMapping("/api/food-ingredients/{id}")
    FoodIngredientMappingDto updateMapping(
            @PathVariable("id") Long id,
            @RequestBody FoodIngredientMappingDto mappingDto
    );

    @DeleteMapping("/api/food-ingredients/{id}")
    void deleteMapping(@PathVariable("id") Long id);
}
