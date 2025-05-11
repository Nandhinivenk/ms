package com.cloudkitchen.order_ms.service;

import com.cloudkitchen.order_ms.dto.FoodIngredientMapping;
import com.cloudkitchen.order_ms.dto.KitchenFlowRequest;
import com.cloudkitchen.order_ms.external.FoodIngredientMappingClient;
import com.cloudkitchen.order_ms.external.InventoryClient;
import com.cloudkitchen.order_ms.external.KitchenFlowClient;
import com.cloudkitchen.order_ms.model.OrderItem;
import com.cloudkitchen.order_ms.repository.OrderRepository;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final KitchenFlowClient kitchenFlowClient;

    private final FoodIngredientMappingClient ingredientMappingClient;

    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepo, InventoryClient inventoryClient,
                        KitchenFlowClient kitchenFlowClient, FoodIngredientMappingClient ingredientMappingClient) {
        this.orderRepo = orderRepo;
        this.inventoryClient = inventoryClient;
        this.kitchenFlowClient = kitchenFlowClient;
        this.ingredientMappingClient = ingredientMappingClient;
    }


    public OrderItem placeOrder(OrderItem orderItem) {
        try {
            // 1. Check Inventory
            List<FoodIngredientMapping> ingredients = ingredientMappingClient.getMappingsByFoodItemId(orderItem.getFoodItemId());

            for (FoodIngredientMapping mapping : ingredients) {
                double totalRequired = mapping.getQuantityRequired() * orderItem.getQuantityOrdered();
                inventoryClient.reduceInventory(mapping.getInventoryItemId(), totalRequired);
            }

            // 2. Save Order
            orderItem.setOrderStatus("RECEIVED");
            OrderItem saved = orderRepo.save(orderItem);

            // 3. Notify Kitchen
            KitchenFlowRequest request = new KitchenFlowRequest();
            request.setOrderId(saved.getId());
            request.setStatus("RECEIVED");
            kitchenFlowClient.createKitchenFlow(request);

            return saved;

        } catch (FeignException.BadRequest e) {
            String errorMessage = e.contentUTF8();
            // Log and/or send a notification here if desired
            throw new RuntimeException("Order failed due to insufficient inventory: " + errorMessage);
        }
    }

    public List<OrderItem> getAllOrders() {
        return orderRepo.findAll();
    }

    public OrderItem getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<OrderItem> getOrdersByCustomer(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}
