package com.cloudkitchen.admin_ms.client;

import com.cloudkitchen.admin_ms.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "notification-ms")
public interface NotificationClient {

    @GetMapping("/api/notifications")
    List<NotificationDto> getAllNotifications();
}
