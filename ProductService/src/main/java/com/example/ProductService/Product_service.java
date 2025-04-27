package com.example.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Product_service {
     @Autowired
	private Product_repositary  repository;
	
	
	public  String saveproduct(Product product) {
		 repository.save(product);
		return "Product added Successfully";
	}

	public List<Product> getAllProduct() {
		
		return repository.findAll();
	}



	public Product getProduct(int id) {
		return repository.findById(id).get();
	}

	public String deleteProduct(int id) {
		 repository.deleteById(id);
		 return "Product Deleted Sucessfully";
	}

}
