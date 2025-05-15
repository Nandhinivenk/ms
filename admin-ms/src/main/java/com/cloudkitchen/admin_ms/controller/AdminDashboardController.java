package com.cloudkitchen.admin_ms.controller;

import com.cloudkitchen.admin_ms.client.*;
import com.cloudkitchen.admin_ms.dto.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class AdminDashboardController {

    private final CustomerClient customerClient;
    private final OrderClient orderClient;
    private final FoodItemClient foodItemClient;
    private final InventoryClient inventoryClient;
    private final FoodIngredientMappingClient mappingClient;
    private final KitchenFlowClient kitchenFlowClient;
    private final NotificationClient notificationClient;

    public AdminDashboardController(
            CustomerClient customerClient,
            OrderClient orderClient,
            FoodItemClient foodItemClient,
            InventoryClient inventoryClient,
            FoodIngredientMappingClient mappingClient,
            KitchenFlowClient kitchenFlowClient,
            NotificationClient notificationClient // new
    ) {
        this.customerClient = customerClient;
        this.orderClient = orderClient;
        this.foodItemClient = foodItemClient;
        this.inventoryClient = inventoryClient;
        this.mappingClient = mappingClient;
        this.kitchenFlowClient = kitchenFlowClient;
        this.notificationClient = notificationClient;
    }
    // Existing endpoints...


    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerClient.getAllCustomers());
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderClient.getAllOrders());
    }

    @GetMapping("/orders/customer/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderClient.getOrdersByCustomer(customerId));
    }

    // 📦 Food Item Endpoints
    @GetMapping("/fooditems")
    public ResponseEntity<List<FoodItemDto>> getAllFoodItems() {
        return ResponseEntity.ok(foodItemClient.getAllFoodItems());
    }

    @PostMapping("/fooditems")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto item) {
        return ResponseEntity.ok(foodItemClient.addFoodItem(item));
    }

    @PutMapping("/fooditems/{id}")
    public ResponseEntity<FoodItemDto> updateFoodItem(@PathVariable Long id, @RequestBody FoodItemDto item) {
        return ResponseEntity.ok(foodItemClient.updateFoodItem(id, item));
    }

    @DeleteMapping("/fooditems/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        foodItemClient.deleteFoodItem(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryItemDto>> getAllInventoryItems() {
        return ResponseEntity.ok(inventoryClient.getAllInventory());
    }

    @PostMapping("/inventory")
    public ResponseEntity<InventoryItemDto> addInventoryItem(@RequestBody InventoryItemDto item) {
        return ResponseEntity.ok(inventoryClient.addInventory(item));
    }

    @PutMapping("/inventory/{id}")
    public ResponseEntity<InventoryItemDto> updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItemDto item) {
        return ResponseEntity.ok(inventoryClient.updateInventory(id, item));
    }


    // Serve QR Code image for inventory item by ID
    @GetMapping("/inventory/{id}/qrcode")
    public ResponseEntity<byte[]> getQRCodeForInventoryItem(@PathVariable Long id) throws IOException {
        String filePath = "qrcodes/inventory_" + id + ".png";

        // Read image as byte array
        byte[] imageBytes = Files.readAllBytes(Paths.get(filePath));

        // Set content type and return
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return ResponseEntity.ok()
                .headers(headers)
                .body(imageBytes);
    }


    @PostMapping("/mappings")
    public ResponseEntity<FoodIngredientMappingDto> addMapping(@RequestBody FoodIngredientMappingDto mapping) {
        return ResponseEntity.ok(mappingClient.addMapping(mapping));
    }

    @GetMapping("/mappings/{foodItemId}")
    public ResponseEntity<List<FoodIngredientMappingDto>> getMappings(@PathVariable Long foodItemId) {
        return ResponseEntity.ok(mappingClient.getMappingsByFoodItem(foodItemId));
    }

    @DeleteMapping("/mappings/{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Long id) {
        mappingClient.deleteMapping(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kitchenflows")
    public ResponseEntity<List<KitchenFlowDto>> getAllKitchenFlows() {
        return ResponseEntity.ok(kitchenFlowClient.getAllWorkflows());
    }

    @PutMapping("/kitchenflows/{id}")
    public ResponseEntity<KitchenFlowDto> updateKitchenFlowStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(kitchenFlowClient.updateWorkflowStatus(id, status));
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDto>> getAllNotifications() {
        return ResponseEntity.ok(notificationClient.getAllNotifications());
    }




}
