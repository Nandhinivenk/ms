package com.cloudkitchen.foodingredientmapping_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Replace with the correct service name registered in Eureka
@FeignClient(name = "fooditem-ms")
public interface FoodItemClient {

    @GetMapping("/api/food-items/{id}")
    com.cloudkitchen.foodingredientmapping_ms.dto.FoodItemDto getFoodItemById(@PathVariable("id") Long id);
}
