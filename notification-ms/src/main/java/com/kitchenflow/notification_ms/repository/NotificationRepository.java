package com.kitchenflow.notification_ms.repository;

import com.kitchenflow.notification_ms.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
