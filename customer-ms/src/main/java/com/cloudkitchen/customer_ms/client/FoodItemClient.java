package com.cloudkitchen.customer_ms.client;

import com.cloudkitchen.customer_ms.dto.FoodItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// FoodItemClient.java
@FeignClient(name = "fooditem-ms")
public interface FoodItemClient {
    @GetMapping("/api/food-items")
    List<FoodItemDTO> getAllFoodItems();

    @GetMapping("/api/food-items/{id}")
    FoodItemDTO getFoodItemById(@PathVariable("id") Long id);
}
