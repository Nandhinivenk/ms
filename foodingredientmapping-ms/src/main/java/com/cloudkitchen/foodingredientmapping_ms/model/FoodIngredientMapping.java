package com.cloudkitchen.foodingredientmapping_ms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FoodIngredientMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodItemId;
    private Long inventoryItemId;
    private Double quantityRequired;
}
