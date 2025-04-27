package com.example.ProductService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_repositary extends JpaRepository<Product, Integer> {

}
