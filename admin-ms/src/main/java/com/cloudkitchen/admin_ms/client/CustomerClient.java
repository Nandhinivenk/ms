package com.cloudkitchen.admin_ms.client;
import com.cloudkitchen.admin_ms.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customer-ms")
public interface CustomerClient {

    @GetMapping("/api/customers")
    List<CustomerDto> getAllCustomers();
}
