package com.saicharan.Inventory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.Inventory.models.Order;
import com.saicharan.Inventory.services.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order/create", method = RequestMethod.POST)
	public void createDistributor(@RequestBody Order order) {
		orderService.createOrder(order);
	}
	
	@RequestMapping(value = "/orders")
	public List<Order> getDistributors(){
		return orderService.getOrders();
	}
	
	@RequestMapping(value = "/order/{orderId}")
	public Optional<Order> getDistributor(@PathVariable(value = "orderId") String orderId) {
		return orderService.getOrderById(orderId);
	}

}
