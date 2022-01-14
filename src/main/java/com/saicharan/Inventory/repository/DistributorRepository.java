package com.saicharan.Inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saicharan.Inventory.models.Distributor;

public interface DistributorRepository extends MongoRepository<Distributor, String>{

}
