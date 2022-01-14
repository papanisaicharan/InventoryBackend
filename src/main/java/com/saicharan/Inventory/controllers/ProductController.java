package com.saicharan.Inventory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.Inventory.models.Product;
import com.saicharan.Inventory.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public void createSupplier(@RequestBody Product product) {
		productService.createProduct(product);
	}
	
	@RequestMapping(value = "/products")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@RequestMapping(value = "/product/{productId}")
	public Optional<Product> getProduct(@PathVariable(value = "productId") String productId) {
		return productService.getProductById(productId);
	}
}
