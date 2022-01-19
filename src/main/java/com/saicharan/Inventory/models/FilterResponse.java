package com.saicharan.Inventory.models;

import java.util.List;

public class FilterResponse {

	private List<Order> orders;
	private int total;
	private int result;
	public FilterResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterResponse(List<Order> orders, int total, int result) {
		super();
		this.orders = orders;
		this.total = total;
		this.result = result;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
}
