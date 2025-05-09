package com.cloudkitchen.inventoryitem_ms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double quantity;
    private String unit;

    private Double lowStockThreshold = 2.0;

    @Column(name = "notified")
    private boolean notified = false;
}
