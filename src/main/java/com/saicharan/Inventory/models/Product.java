package com.saicharan.Inventory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *  To reduce the boilerplate code we can using lombok
 */

@Document
public class Product {
	@Id
	private String productId;
	private String productName;
	private String productDescription;
	private int quantity;
	private String units;
	private String supplierId;
	private float perUnitPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productId, String productName, String productDescription, int quantity, String units,
			String supplierId, float perUnitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.units = units;
		this.supplierId = supplierId;
		this.perUnitPrice = perUnitPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public float getPerUnitPrice() {
		return perUnitPrice;
	}
	public void setPerUnitPrice(float perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}
	
	
}
