package com.cloudkitchen.foodingredientmapping_ms.service;

import com.cloudkitchen.foodingredientmapping_ms.external.FoodItemClient;
import com.cloudkitchen.foodingredientmapping_ms.external.InventoryItemClient;
import com.cloudkitchen.foodingredientmapping_ms.model.FoodIngredientMapping;
import com.cloudkitchen.foodingredientmapping_ms.repository.FoodIngredientMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodIngredientMappingService {

    private final FoodIngredientMappingRepository repository;
    private final FoodItemClient foodItemClient;
    private final InventoryItemClient inventoryItemClient;

    public FoodIngredientMappingService(InventoryItemClient inventoryItemClient,FoodIngredientMappingRepository repository, FoodItemClient foodItemClient) {
        this.repository = repository;
        this.foodItemClient = foodItemClient;
        this.inventoryItemClient=inventoryItemClient;
    }

    public FoodIngredientMapping addMapping(FoodIngredientMapping mapping) {
        // Validate the foodItemId by calling FoodItem service
        foodItemClient.getFoodItemById(mapping.getFoodItemId());
        inventoryItemClient.getInventoryItemById(mapping.getInventoryItemId());
        return repository.save(mapping);
    }

    public List<FoodIngredientMapping> getMappingsForFoodItem(Long foodItemId) {
        return repository.findByFoodItemId(foodItemId);
    }

    public void deleteMapping(Long id) {
        repository.deleteById(id);
    }
}
