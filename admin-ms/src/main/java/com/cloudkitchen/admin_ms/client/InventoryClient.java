package com.cloudkitchen.admin_ms.client;

import com.cloudkitchen.admin_ms.dto.InventoryItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "inventoryitem-ms")
public interface InventoryClient {

    @GetMapping("/inventory")
    List<InventoryItemDto> getAllInventory();

    @GetMapping("/inventory/{id}")
    InventoryItemDto getInventoryById(@PathVariable("id") Long id);

    @PostMapping("/inventory")
    InventoryItemDto addInventory(@RequestBody InventoryItemDto item);

    @PutMapping("/inventory/{id}")
    InventoryItemDto updateInventory(@PathVariable("id") Long id, @RequestBody InventoryItemDto item);

    @PostMapping("/inventory/{id}/reduce")
    void reduceInventory(@PathVariable("id") Long id, @RequestParam("quantity") Double quantity);
}
