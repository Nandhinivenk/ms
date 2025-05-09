package com.cloudkitchen.order_ms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long foodItemId;
    private Integer quantityOrdered;
    private String orderStatus;
}
