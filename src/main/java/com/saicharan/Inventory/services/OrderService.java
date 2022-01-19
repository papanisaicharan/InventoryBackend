package com.saicharan.Inventory.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Or;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.TextSearchOptions;
import com.saicharan.Inventory.exceptions.GenericException;
import com.saicharan.Inventory.models.Distributor;
import com.saicharan.Inventory.models.FilterResponse;
import com.saicharan.Inventory.models.Order;
import com.saicharan.Inventory.models.Product;
import com.saicharan.Inventory.repository.OrderRepository;
import static com.mongodb.client.model.Filters.text;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DistributorService distributorService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public ResponseEntity<String> createOrder(Order order) {
		Distributor distributor = distributorService.getDistributorById(order.getDistributorId()).get();
		Product product  = productService.getProductById(order.getProductId()).get();
		if(product == null || distributor == null) {
			throw new GenericException("Selected product or distributor is no more available.", "DataNotFoundLabel");
		}
		if(product.getQuantity() - Integer.parseInt(order.getQuantity()) < 0) {
			throw new GenericException("Required quantity is not available in stock.", "DataNotFoundLabel");
		}
		product.setQuantity(product.getQuantity() - Integer.parseInt(order.getQuantity()));
		productService.createProduct(product);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		order.setOrderedOn(formatter.format(new Date()));
//		if the frontend is sending these then we no longer require this
		order.setDistributorName(distributor.getFirstName()+ " " + distributor.getLastName());
		order.setProductName(product.getProductName());
		orderRepository.save(order);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}

	public FilterResponse getOrders(String searchTerm) {
		FilterResponse filterResponse = new FilterResponse();
		List<Order> totalOrders = orderRepository.findAll();
		filterResponse.setTotal(totalOrders.size());
		filterResponse.setOrders(new ArrayList<Order>());
		try {
			if(searchTerm == null || searchTerm.strip().length() == 0) {
				filterResponse.setResult(totalOrders.size());
				filterResponse.setOrders(totalOrders);
			}else {
				TextIndexDefinition textIndex = new TextIndexDefinitionBuilder()
						  .onField("productName")
						  .onField("totalPrice")
						  .onField("orderedOn")
						  .onField("quantity")
						  .onField("distributorName")
						  .onField("deliveryAddress")
						  .build();
				mongoTemplate.indexOps(Order.class).ensureIndex(textIndex);
				TextQuery textQuery = TextQuery.queryText(new TextCriteria().matchingAny(searchTerm));
				List<Order> orders = mongoTemplate.find(textQuery, Order.class);
				filterResponse.setOrders(orders);
				filterResponse.setResult(orders.size());
			}
		}catch(Exception ex) {
			throw new GenericException("Error while performing search - Criteria or index", "CriteriaBuildError");
		}
		return filterResponse;
	}

	public Order getOrderById(String orderId) {
		Order order = orderRepository.findById(orderId).get();
		if(order == null) {
			throw new GenericException("Required order is more in records.", "DataNotFoundLabel");
		}
		return order;
	}
	
	public ResponseEntity<String> UpdateOrder(Order order) {
		Order oldOrder = orderRepository.findById(order.getOrderId()).get();
		Product product = productService.getProductById(order.getProductId()).get();
		if(oldOrder == null || product == null) {
			throw new GenericException("Selected product or order is no more available in database.", "DataNotFoundLabel");
		}
		// if the order quantity is reduced, add the difference of new quantity and old quantity to products quantity
		// if the order quantity is increased, add the difference to product quantity
		int difference = Integer.parseInt(order.getQuantity()) - Integer.parseInt(oldOrder.getQuantity());
		if(difference >= 0) {
			if(product.getQuantity() >= difference) {
				orderRepository.save(order);
			}else {
				throw new GenericException("Insufficent quantity.", "DataNotFoundLabel");
			}
		}else {
			orderRepository.save(order);
		}
		product.setQuantity(product.getQuantity()-difference);
		productService.createProduct(product);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteOrder(String orderId) {
		Order order = null;
		try {
			order = orderRepository.findById(orderId).get();
			Product product = productService.getProductById(order.getProductId()).get();
			product.setQuantity(product.getQuantity()+Integer.parseInt(order.getQuantity()));
			productService.createProduct(product);
			orderRepository.deleteById(orderId);
		}catch(Exception ex) {
			throw new GenericException("Order or associated product is missing..!", "DataNotFoundException");
		}
		return new ResponseEntity<String>( HttpStatus.OK);
		
	}
	
}
