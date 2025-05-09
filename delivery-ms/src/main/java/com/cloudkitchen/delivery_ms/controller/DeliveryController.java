package com.cloudkitchen.delivery_ms.controller;

import com.cloudkitchen.delivery_ms.model.DeliveryAssignment;
import com.cloudkitchen.delivery_ms.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> assignDelivery(@RequestParam Long orderId, @RequestParam String deliveryPerson) {
        try {
            return ResponseEntity.ok(service.assignDelivery(orderId, deliveryPerson));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<DeliveryAssignment>> getAllDeliveries() {
        return ResponseEntity.ok(service.getAllDeliveries());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryAssignment> updateDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateDeliveryStatus(id, status));
    }
}

