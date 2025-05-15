package com.cloudkitchen.customer_ms.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private Long foodItemId;
    private Integer quantityOrdered;
    private String orderStatus;
}