package com.cloudkitchen.inventoryitem_ms.service;

import com.cloudkitchen.inventoryitem_ms.exception.InsufficientStockException;
import com.cloudkitchen.inventoryitem_ms.model.InventoryItem;
import com.cloudkitchen.inventoryitem_ms.repository.InventoryRepository;
import com.cloudkitchen.inventoryitem_ms.utils.QRCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final NotificationService notificationService;

    public InventoryService(InventoryRepository inventoryRepository, NotificationService notificationService) {
        this.inventoryRepository = inventoryRepository;
        this.notificationService = notificationService;
    }

    public InventoryItem addInventoryItem(InventoryItem item) {
        InventoryItem saved = inventoryRepository.save(item);
        String qrText = "ID: " + saved.getId() + "\nName: " + saved.getName() +
                "\nQuantity: " + saved.getQuantity() + "\nUnit: " + saved.getUnit();
        String qrFilePath = "qrcodes/inventory_" + saved.getId() + ".png";

        try {
            QRCodeGenerator.generateQRCodeImage(qrText, qrFilePath);
        } catch (Exception e) {
            System.err.println("QR Code generation failed: " + e.getMessage());
        }

        return saved;
    }

    public List<InventoryItem> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public InventoryItem getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory Item not found"));
    }

    public InventoryItem updateInventory(Long id, InventoryItem updatedItem) {
        InventoryItem existing = getInventoryById(id);
        existing.setName(updatedItem.getName());
        existing.setQuantity(updatedItem.getQuantity());
        existing.setUnit(updatedItem.getUnit());
        return inventoryRepository.save(existing);
    }

    public void regenerateQRCode(InventoryItem item) {
        String qrText = "ID: " + item.getId() + "\nName: " + item.getName() +
                "\nQuantity: " + item.getQuantity() + "\nUnit: " + item.getUnit();
        String qrFilePath = "qrcodes/inventory_" + item.getId() + ".png";

        try {
            QRCodeGenerator.generateQRCodeImage(qrText, qrFilePath);
        } catch (Exception e) {
            System.err.println("QR update failed: " + e.getMessage());
        }
    }

    public void reduceInventory(Long id, Double quantity) {
        InventoryItem item = getInventoryById(id);
        if (item.getQuantity() < quantity) {
            throw new InsufficientStockException("Not enough stock for item: " + item.getName());
        }

        item.setQuantity(item.getQuantity() - quantity);
        InventoryItem updated = inventoryRepository.save(item);
        regenerateQRCode(updated);

        if (updated.getQuantity() < updated.getLowStockThreshold()) {
            String msg = "Low stock alert for item: " + updated.getName() +
                    " (" + updated.getQuantity() + " " + updated.getUnit() + ")";
            notificationService.addLowStockAlert(msg);
        }
    }
}
