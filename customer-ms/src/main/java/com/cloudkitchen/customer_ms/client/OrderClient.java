package com.cloudkitchen.customer_ms.client;

import com.cloudkitchen.customer_ms.dto.OrderItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "order-ms")
public interface OrderClient {
    @PostMapping("/orders")
    OrderItemDTO placeOrder(@RequestBody OrderItemDTO orderItem);

    @GetMapping("/orders/customer/{customerId}")
    List<OrderItemDTO> getOrdersByCustomer(@PathVariable("customerId") Long customerId);
}
