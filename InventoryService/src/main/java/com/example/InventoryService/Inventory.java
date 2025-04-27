package com.example.InventoryService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inventory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private int quantity;
    
}
