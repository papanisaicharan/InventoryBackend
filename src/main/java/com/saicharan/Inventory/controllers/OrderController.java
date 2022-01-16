package com.saicharan.Inventory.controllers;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.Inventory.models.Order;
import com.saicharan.Inventory.models.Product;
import com.saicharan.Inventory.models.Status;
import com.saicharan.Inventory.services.OrderService;
import com.saicharan.Inventory.services.ProductService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order/create", method = RequestMethod.POST)
	public ResponseEntity<String> createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@RequestMapping(value = "/orders")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@RequestMapping(value = "/order/{orderId}")
	public Order getOrder(@PathVariable(value = "orderId") String orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@RequestMapping(value = "/order/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateOrder(@RequestBody Order order){
		return orderService.UpdateOrder(order);
	}
	
	@RequestMapping(value = "/order/delete/{orderId}", method = RequestMethod.POST)
	public ResponseEntity<String> deleteOrder(@PathVariable(value = "orderId") String orderId){
		return orderService.deleteOrder(orderId);
	}

}
