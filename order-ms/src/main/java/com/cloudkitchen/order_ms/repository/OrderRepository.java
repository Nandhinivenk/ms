package com.cloudkitchen.order_ms.repository;

import com.cloudkitchen.order_ms.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByCustomerId(Long customerId);
}

