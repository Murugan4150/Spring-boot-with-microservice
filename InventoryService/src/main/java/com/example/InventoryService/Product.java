package com.example.InventoryService;

import lombok.Data;

@Data
public class Product {

	private int product_id;
    private String product_name;
    private int price;
    private String category;
}
