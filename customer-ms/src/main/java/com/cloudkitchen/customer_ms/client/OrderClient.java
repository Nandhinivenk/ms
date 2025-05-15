package com.cloudkitchen.customer_ms.client;

import com.cloudkitchen.customer_ms.dto.OrderItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "order-ms", url = "http://localhost:8099/orders")
public interface OrderClient {
    @PostMapping
    OrderItemDTO placeOrder(@RequestBody OrderItemDTO orderItem);

    @GetMapping("/customer/{customerId}")
    List<OrderItemDTO> getOrdersByCustomer(@PathVariable("customerId") Long customerId);
}
