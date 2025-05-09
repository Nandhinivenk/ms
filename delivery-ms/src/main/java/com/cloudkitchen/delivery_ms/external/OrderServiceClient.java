package com.cloudkitchen.delivery_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-ms")
public interface OrderServiceClient {
    @GetMapping("/orders/exists/{orderId}")
    boolean checkOrderExists(@PathVariable("orderId") Long orderId);
}
