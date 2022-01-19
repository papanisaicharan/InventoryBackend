package com.saicharan.Inventory.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  To reduce the boilerplate code we can using lombok
 */

@CompoundIndex(def = "{'productName': 1, 'totalPrice': 1, 'orderedOn': 1, 'quantity': 1, 'distributorName': 1, 'deliveryAddress': 1}")
@Document
public class Order {
	@Id
	private String orderId;
	@TextIndexed private String productName;
	private String productId;
	@TextIndexed private String totalPrice;
	@TextIndexed private String orderedOn;
	@TextIndexed private String quantity;
	@TextIndexed private String distributorName;
	private String distributorId;
	@TextIndexed private String deliveryAddress;
//	private Status status; 
	public Order(String orderId, String productName, String productId, String totalPrice, String orderedOn,
			String quantity, String distributorName, String distributorId, String deliveryAddress) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.productId = productId;
		this.totalPrice = totalPrice;
		this.orderedOn = orderedOn;
		this.quantity = quantity;
		this.distributorName = distributorName;
		this.distributorId = distributorId;
		this.deliveryAddress = deliveryAddress;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(String orderedOn) {
		this.orderedOn = orderedOn;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
}
