package com.cloudkitchen.order_ms.dto;
// order-ms/src/main/java/com/cloudkitchen/order_ms/dto/KitchenFlowRequest.java

public class KitchenFlowRequest {
    private Long orderId;
    private String status;

    // Getters and setters

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
