package com.cloudkitchen.delivery_ms.repository;

import com.cloudkitchen.delivery_ms.model.DeliveryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryAssignmentRepository extends JpaRepository<DeliveryAssignment, Long> {
    Optional<DeliveryAssignment> findByOrderId(Long orderId);
}

