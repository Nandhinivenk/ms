package com.cloudkitchen.foodingredientmapping_ms.service;


import com.cloudkitchen.foodingredientmapping_ms.model.FoodIngredientMapping;
import com.cloudkitchen.foodingredientmapping_ms.repository.FoodIngredientMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodIngredientMappingService {

    private final FoodIngredientMappingRepository mappingRepository;

    public FoodIngredientMappingService(FoodIngredientMappingRepository mappingRepository) {
        this.mappingRepository = mappingRepository;
    }

    public FoodIngredientMapping addMapping(FoodIngredientMapping mapping) {
        return mappingRepository.save(mapping);
    }

    public List<FoodIngredientMapping> getMappingsForFoodItem(Long foodItemId) {
        return mappingRepository.findByFoodItemId(foodItemId);
    }

    public void deleteMapping(Long id) {
        mappingRepository.deleteById(id);
    }
}
