package com.saicharan.Inventory.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
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

@Document
public class Order {
	@Id
	private String orderId;
	private String productName;
	private String productId;
	private float totalPrice;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date orderedOn;
	private int quantity;
	private String distributorName;
	private String distributorId;
	private String deliveryAddress;
//	private Status status; 
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, String productName, String productId, float totalPrice, Date orderedOn, int quantity,
			String distributorName, String distributorId, String deliveryAddress) {
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
//		this.status = status;
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
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
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
//	public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	
}
