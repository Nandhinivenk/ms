package com.kitchenflow.notification_ms.controller;

import com.kitchenflow.notification_ms.model.Notification;
import com.kitchenflow.notification_ms.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAllNotifications();
    }

    @PostMapping("/low-stock")
    public void addLowStockNotification(@RequestParam String message) {
        notificationService.addLowStockAlert(message);
    }
}
