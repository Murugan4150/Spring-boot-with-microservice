package com.example.OrderService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE", url = "http://localhost:8082/inventory")
public interface InventoryServiceClient {

	@GetMapping("/{productId}")
	public Inventory getInventoryByProductId(@PathVariable long productid);

	@PutMapping("/deductstock")
	public void deductStock(Inventory inventory);
    
}

