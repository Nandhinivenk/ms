package com.cloudkitchen.inventoryitem_ms.controller;

import com.cloudkitchen.inventoryitem_ms.model.InventoryItem;
import com.cloudkitchen.inventoryitem_ms.service.InventoryService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryItem> addInventory(@RequestBody InventoryItem item) {
        return ResponseEntity.ok(inventoryService.addInventoryItem(item));
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllInventory() {
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getInventoryById(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryService.getInventoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> updateInventory(@PathVariable Long id, @RequestBody InventoryItem item) {
        return ResponseEntity.ok(inventoryService.updateInventory(id, item));
    }

    @PostMapping("/{id}/reduce")
    public ResponseEntity<Void> reduceInventory(@PathVariable Long id, @RequestParam Double quantity) {
        inventoryService.reduceInventory(id, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/qrcode")
    public ResponseEntity<byte[]> getQRCode(@PathVariable Long id) throws IOException {
        InventoryItem item = inventoryService.getInventoryById(id);
        Path path = Paths.get("qrcodes/inventory_" + item.getId() + ".png");
        byte[] image = Files.readAllBytes(path);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(image);
    }

}
