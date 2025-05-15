package com.cloudkitchen.customer_ms.dto;

import lombok.Data;
// src/main/java/com/cloudkitchen/customer_ms/dto/OrderStatusDTO.java


import lombok.Data;

@Data
public class OrderStatusDTO {
    private Long orderId;
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
