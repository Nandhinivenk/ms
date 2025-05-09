package com.cloudkitchen.fooditem_ms.service;

import com.cloudkitchen.fooditem_ms.model.FoodItem;
import com.cloudkitchen.fooditem_ms.model.FoodIngredientMapping;
import com.cloudkitchen.fooditem_ms.repository.FoodIngredientMappingRepository;
import com.cloudkitchen.fooditem_ms.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final FoodIngredientMappingRepository ingredientMappingRepository;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodIngredientMappingRepository ingredientMappingRepository) {
        this.foodItemRepository = foodItemRepository;
        this.ingredientMappingRepository = ingredientMappingRepository;
    }

    public FoodItem addFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found"));
    }

    public FoodItem updateFoodItem(Long id, FoodItem updatedFood) {
        FoodItem existing = foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found"));

        existing.setName(updatedFood.getName());
        existing.setPrice(updatedFood.getPrice());
        existing.setAvailable(updatedFood.getAvailable());

        return foodItemRepository.save(existing);
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }

    public List<FoodIngredientMapping> getIngredientsForFoodItem(Long foodId) {
        return ingredientMappingRepository.findByFoodItemId(foodId);
    }
}
