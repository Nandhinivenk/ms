package com.cloudkitchen.delivery_ms.external;

import com.cloudkitchen.delivery_ms.dto.OrderItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-ms",url = "http://localhost:8099/orders")
public interface OrderServiceClient {
    @GetMapping("/{orderId}")
    OrderItemDto getOrderById(@PathVariable("orderId") Long orderId);
}


