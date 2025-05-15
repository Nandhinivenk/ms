package com.cloudkitchen.order_ms.external;

import com.cloudkitchen.order_ms.dto.FoodIngredientMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "foodingredientmapping-ms")
public interface FoodIngredientMappingClient {

    @GetMapping("/api/food-ingredients/{foodItemId}")
    List<FoodIngredientMapping> getMappingsByFoodItemId(@PathVariable("foodItemId") Long foodItemId);
}
