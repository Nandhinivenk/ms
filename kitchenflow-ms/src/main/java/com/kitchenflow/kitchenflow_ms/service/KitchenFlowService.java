package com.kitchenflow.kitchenflow_ms.service;

import com.kitchenflow.kitchenflow_ms.exception.ResourceNotFoundException;
import com.kitchenflow.kitchenflow_ms.model.KitchenFlow;
import com.kitchenflow.kitchenflow_ms.repository.KitchenFlowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenFlowService {

    private final KitchenFlowRepository kitchenFlowRepository;

    public KitchenFlowService(KitchenFlowRepository kitchenFlowRepository) {
        this.kitchenFlowRepository = kitchenFlowRepository;
    }

    public List<KitchenFlow> getAllWorkflows() {
        return kitchenFlowRepository.findAll();
    }

    public KitchenFlow createWorkflow(KitchenFlow flow) {
        flow.setStatus("RECEIVED");
        return kitchenFlowRepository.save(flow);
    }

    public KitchenFlow getByOrderId(Long orderId) {
        return kitchenFlowRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("No flow for order " + orderId));
    }

    public KitchenFlow updateWorkflowStatus(Long id, String newStatus) {
        KitchenFlow workflow = kitchenFlowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workflow not found"));
        workflow.setStatus(newStatus);
        return kitchenFlowRepository.save(workflow);
    }
}
