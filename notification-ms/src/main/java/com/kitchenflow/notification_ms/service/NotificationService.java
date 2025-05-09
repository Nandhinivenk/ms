package com.kitchenflow.notification_ms.service;

import com.kitchenflow.notification_ms.model.Notification;
import com.kitchenflow.notification_ms.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void addLowStockAlert(String message) {
        Notification n = new Notification();
        n.setMessage(message);
        n.setType("LOW_STOCK");
        n.setTimestamp(LocalDateTime.now());
        notificationRepository.save(n);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
