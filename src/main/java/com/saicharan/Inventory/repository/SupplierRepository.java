package com.saicharan.Inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saicharan.Inventory.models.Supplier;

public interface SupplierRepository extends MongoRepository<Supplier, String>{

}
