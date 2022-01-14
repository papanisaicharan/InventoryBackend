package com.saicharan.Inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saicharan.Inventory.models.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
