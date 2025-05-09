package com.cloudkitchen.foodingredientmapping_ms.repository;


import com.cloudkitchen.foodingredientmapping_ms.model.FoodIngredientMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodIngredientMappingRepository extends JpaRepository<FoodIngredientMapping, Long> {
    List<FoodIngredientMapping> findByFoodItemId(Long foodItemId);
}
