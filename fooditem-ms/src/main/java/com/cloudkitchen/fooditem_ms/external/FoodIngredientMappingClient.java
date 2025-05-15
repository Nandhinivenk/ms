package com.cloudkitchen.fooditem_ms.external;

import com.cloudkitchen.fooditem_ms.dto.FoodIngredientMappingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "foodingredientmapping-ms",url = "http://localhost:8094/api/food-ingredients")
public interface FoodIngredientMappingClient {

    @GetMapping("/{foodItemId}")
    List<FoodIngredientMappingDTO> getMappingsByFoodItemId(@PathVariable("foodItemId") Long foodItemId);
}
