package com.cloudkitchen.order_ms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-ms",url = "http://localhost:8092/api/customers")
public interface CustomerClient {
    @GetMapping("/{id}")
    Object getCustomerById(@PathVariable("id") Long id);
}