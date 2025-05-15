package com.cloudkitchen.admin_ms.client;

import com.cloudkitchen.admin_ms.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "order-ms")
public interface OrderClient {

    @GetMapping("/orders")
    List<OrderDto> getAllOrders();

    @GetMapping("/orders/customer/{customerId}")
    List<OrderDto> getOrdersByCustomer(@PathVariable("customerId") Long customerId);
}
