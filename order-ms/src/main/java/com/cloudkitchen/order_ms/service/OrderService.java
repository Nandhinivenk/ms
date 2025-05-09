package com.cloudkitchen.order_ms.service;
import com.cloudkitchen.order_ms.model.OrderItem;
import com.cloudkitchen.order_ms.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderItem placeOrder(OrderItem orderItem) {
        orderItem.setOrderStatus("RECEIVED");
        return orderRepo.save(orderItem);
    }

    public List<OrderItem> getAllOrders() {
        return orderRepo.findAll();
    }

    public OrderItem getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<OrderItem> getOrdersByCustomer(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}

