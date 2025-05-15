package com.cloudkitchen.customer_ms.client;

import com.cloudkitchen.customer_ms.dto.FoodItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// FoodItemClient.java
@FeignClient(name = "fooditem-ms", url = "http://localhost:8095/api/food-items")
public interface FoodItemClient {
    @GetMapping
    List<FoodItemDTO> getAllFoodItems();

    @GetMapping("/{id}")
    FoodItemDTO getFoodItemById(@PathVariable("id") Long id);
}
