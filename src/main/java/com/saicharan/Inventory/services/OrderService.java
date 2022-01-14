package com.saicharan.Inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saicharan.Inventory.models.Order;
import com.saicharan.Inventory.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public void createOrder(Order order) {
		orderRepository.save(order);
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(String orderId) {
		return orderRepository.findById(orderId);
	}
}
