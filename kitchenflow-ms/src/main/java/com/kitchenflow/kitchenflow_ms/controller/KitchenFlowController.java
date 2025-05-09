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

    @GetMapping
    public ResponseEntity<List<KitchenFlow>> getAllWorkflows() {
        return ResponseEntity.ok(kitchenFlowService.getAllWorkflows());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KitchenFlow> updateWorkflowStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(kitchenFlowService.updateWorkflowStatus(id, status));
    }
}
