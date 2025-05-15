package com.cloudkitchen.admin_ms.client;

import com.cloudkitchen.admin_ms.dto.KitchenFlowDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "kitchenflow-ms")
public interface KitchenFlowClient {

    @GetMapping("/kitchen")
    List<KitchenFlowDto> getAllWorkflows();

    @GetMapping("/kitchen/order/{orderId}")
    KitchenFlowDto getByOrderId(@PathVariable("orderId") Long orderId);

    @PutMapping("/kitchen/{id}")
    KitchenFlowDto updateWorkflowStatus(@PathVariable("id") Long id, @RequestParam("status") String status);

    @PostMapping("/kitchen")
    KitchenFlowDto createWorkflow(@RequestBody KitchenFlowDto kitchenFlowDto);
}
