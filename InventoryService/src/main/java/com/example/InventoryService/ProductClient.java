package com.example.InventoryService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Product_service", url = "http://localhost:8081")
public interface ProductClient {

	@GetMapping("/{productid}")
	public boolean validateProduct(int productid);
}
