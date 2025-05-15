package com.cloudkitchen.customer_ms.client;

import com.cloudkitchen.customer_ms.dto.OrderStatusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// KitchenFlowClient.java
@FeignClient(name = "kitchenflow-ms")
public interface KitchenFlowClient {
    @GetMapping("/kitchen/order/{orderId}")
    OrderStatusDTO getStatusByOrderId(@PathVariable("orderId") Long orderId);
}
