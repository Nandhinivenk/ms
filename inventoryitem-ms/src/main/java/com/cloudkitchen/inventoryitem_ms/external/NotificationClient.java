package com.cloudkitchen.inventoryitem_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-ms",url = "http://localhost:8098/api/notifications")  // This must match the service name registered in Eureka
public interface NotificationClient {

    @PostMapping("/low-stock")
    void sendLowStockNotification(@RequestParam("message") String message);
}
