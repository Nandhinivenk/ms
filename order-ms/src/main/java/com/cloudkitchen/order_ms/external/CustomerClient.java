package com.cloudkitchen.order_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-ms")
public interface CustomerClient {
    @GetMapping("/customers/{id}")
    Object getCustomerById(@PathVariable("id") Long id);
}