package com.example.OrderService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8081")
public interface ProductServiceClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);

    @PostMapping("/products/validate")
    boolean validateProduct(@RequestBody Product product);
}

