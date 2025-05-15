package com.cloudkitchen.customer_ms.dto;

import lombok.Data;

@Data
public class FoodItemDTO {
    private Long id;
    private String name;
    private Double price;
    private Boolean available;
}
