package com.cloudkitchen.foodingredientmapping_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Replace with the correct service name registered in Eureka
@FeignClient(name = "inventoryitem-ms", url = "http://localhost:8096/inventory")
public interface InventoryItemClient {

    @GetMapping("/{id}")
    com.cloudkitchen.foodingredientmapping_ms.dto.InventoryItemDto getInventoryItemById(@PathVariable("id") Long id);
}
