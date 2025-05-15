package com.cloudkitchen.customer_ms.controller;

import com.cloudkitchen.customer_ms.client.FoodItemClient;
import com.cloudkitchen.customer_ms.client.KitchenFlowClient;
import com.cloudkitchen.customer_ms.client.OrderClient;
import com.cloudkitchen.customer_ms.dto.FoodItemDTO;
import com.cloudkitchen.customer_ms.dto.OrderItemDTO;
import com.cloudkitchen.customer_ms.dto.OrderStatusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin // allow frontend CORS
public class CustomerDashboardController {

    private final FoodItemClient foodItemClient;
    private final OrderClient orderClient;
    private final KitchenFlowClient kitchenFlowClient;

    public CustomerDashboardController(FoodItemClient foodItemClient, OrderClient orderClient, KitchenFlowClient kitchenFlowClient) {
        this.foodItemClient = foodItemClient;
        this.orderClient = orderClient;
        this.kitchenFlowClient = kitchenFlowClient;
    }

    // ✅ Get menu items
    @GetMapping("/menu")
    public ResponseEntity<List<FoodItemDTO>> getMenu() {
        return ResponseEntity.ok(foodItemClient.getAllFoodItems());
    }

    // ✅ Place an order
    @PostMapping("/place-order")
    public ResponseEntity<OrderItemDTO> placeOrder(@RequestBody OrderItemDTO orderRequest) {
        return ResponseEntity.ok(orderClient.placeOrder(orderRequest));
    }

    // ✅ View customer orders
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<OrderItemDTO>> getOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderClient.getOrdersByCustomer(customerId));
    }

    @GetMapping("/track-order/{orderId}")
    public ResponseEntity<OrderStatusDTO> trackOrder(@PathVariable Long orderId) {
        OrderStatusDTO status = kitchenFlowClient.getStatusByOrderId(orderId);
        return ResponseEntity.ok(status);
    }

}
