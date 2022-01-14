package com.saicharan.Inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saicharan.Inventory.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
