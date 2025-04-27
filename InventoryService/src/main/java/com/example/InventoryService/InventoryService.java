package com.example.InventoryService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private  InventoryRepository inventoryRepository;
    private  ProductClient productClient;

    public Inventory addStock(Inventory inventory) {
    	
        return inventoryRepository.save(inventory);
    }

    public Inventory updateStock(long productId, int quantity) {
    	
        Inventory inventory = inventoryRepository.findById(productId).get();
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    public Inventory getStock(long productId) {
        return inventoryRepository.findById(productId).get();
    }
}
