package com.cloudkitchen.order_ms.external;


 import org.springframework.cloud.openfeign.FeignClient;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "inventoryitem-ms")
public interface InventoryClient {

    @PostMapping("/inventory/{id}/reduce")
    void reduceInventory(@PathVariable("id") Long id, @RequestParam("quantity") double quantity);
}
