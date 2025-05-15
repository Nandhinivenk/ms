package com.cloudkitchen.order_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-ms")
public interface NotificationClient {
    @PostMapping("/api/notifications/low-stock")
    void sendLowStockNotification(@RequestParam("message") String message);
}
