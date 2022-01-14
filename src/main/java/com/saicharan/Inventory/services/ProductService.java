package com.saicharan.Inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saicharan.Inventory.models.Distributor;
import com.saicharan.Inventory.models.Product;
import com.saicharan.Inventory.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(String productId) {
		return productRepository.findById(productId);
	}
}
