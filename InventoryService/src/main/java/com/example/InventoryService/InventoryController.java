package com.example.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public Inventory addStock(@RequestBody Inventory inventory) {
        return inventoryService.addStock(inventory);
    }

    @PutMapping("/{productId}")
    public Inventory updateStock(@PathVariable Long productId, @RequestParam Integer quantity) {
        return inventoryService.updateStock(productId, quantity);
    }

    @GetMapping("/{productId}")
    public Inventory getStock(@PathVariable Long productId) {
        return inventoryService.getStock(productId);
    }
    
    @PutMapping("/deductstock")
    public void deductStock(@RequestBody Inventory inventory) {
    	inventoryService.updateStock(inventory.getProductId(), inventory.getQuantity());
    }
    
}

