package com.cloudkitchen.delivery_ms.service;

import com.cloudkitchen.delivery_ms.external.OrderServiceClient;
import com.cloudkitchen.delivery_ms.model.DeliveryAssignment;
import com.cloudkitchen.delivery_ms.repository.DeliveryAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryAssignmentRepository repository;
    private final OrderServiceClient orderServiceClient;

    public DeliveryService(DeliveryAssignmentRepository repository, OrderServiceClient orderServiceClient) {
        this.repository = repository;
        this.orderServiceClient = orderServiceClient;
    }

    public DeliveryAssignment assignDelivery(Long orderId, String deliveryPersonName) {
        if (!orderServiceClient.checkOrderExists(orderId)) {
            throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
        }

        Optional<DeliveryAssignment> existing = repository.findByOrderId(orderId);
        if (existing.isPresent()) {
            throw new IllegalStateException("Order " + orderId + " already assigned.");
        }

        DeliveryAssignment assignment = new DeliveryAssignment();
        assignment.setOrderId(orderId);
        assignment.setDeliveryPersonName(deliveryPersonName);
        assignment.setDeliveryStatus("ASSIGNED");

        return repository.save(assignment);
    }

    public List<DeliveryAssignment> getAllDeliveries() {
        return repository.findAll();
    }

    public DeliveryAssignment updateDeliveryStatus(Long id, String status) {
        DeliveryAssignment delivery = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery assignment not found"));
        delivery.setDeliveryStatus(status);
        return repository.save(delivery);
    }
}

