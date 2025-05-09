package com.cloudkitchen.foodingredientmapping_ms.service;

import com.cloudkitchen.foodingredientmapping_ms.external.FoodItemClient;
import com.cloudkitchen.foodingredientmapping_ms.model.FoodIngredientMapping;
import com.cloudkitchen.foodingredientmapping_ms.repository.FoodIngredientMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodIngredientMappingService {

    private final FoodIngredientMappingRepository repository;
    private final FoodItemClient foodItemClient;

    public FoodIngredientMappingService(FoodIngredientMappingRepository repository, FoodItemClient foodItemClient) {
        this.repository = repository;
        this.foodItemClient = foodItemClient;
    }

    public FoodIngredientMapping addMapping(FoodIngredientMapping mapping) {
        // Validate the foodItemId by calling FoodItem service
        foodItemClient.getFoodItemById(mapping.getFoodItemId());
        return repository.save(mapping);
    }

    public List<FoodIngredientMapping> getMappingsForFoodItem(Long foodItemId) {
        return repository.findByFoodItemId(foodItemId);
    }

    public void deleteMapping(Long id) {
        repository.deleteById(id);
    }
}
