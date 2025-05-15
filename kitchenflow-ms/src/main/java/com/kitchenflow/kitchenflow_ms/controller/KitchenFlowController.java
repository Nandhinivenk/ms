package com.kitchenflow.kitchenflow_ms.controller;

import com.kitchenflow.kitchenflow_ms.model.KitchenFlow;
import com.kitchenflow.kitchenflow_ms.service.KitchenFlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenFlowController {

    private final KitchenFlowService kitchenFlowService;

    public KitchenFlowController(KitchenFlowService kitchenFlowService) {
        this.kitchenFlowService = kitchenFlowService;
    }

    @PostMapping
    public ResponseEntity<KitchenFlow> createKitchenFlow(@RequestBody KitchenFlow request) {
        return ResponseEntity.ok(kitchenFlowService.createWorkflow(request));
    }

    @GetMapping
    public ResponseEntity<List<KitchenFlow>> getAllWorkflows() {
        return ResponseEntity.ok(kitchenFlowService.getAllWorkflows());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KitchenFlow> updateWorkflowStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(kitchenFlowService.updateWorkflowStatus(id, status));
    }

    // in KitchenFlowController
    @GetMapping("/order/{orderId}")
    public ResponseEntity<KitchenFlow> getByOrderId(@PathVariable Long orderId) {
        KitchenFlow flow = kitchenFlowService.getByOrderId(orderId);
        return ResponseEntity.ok(flow);
    }

}
