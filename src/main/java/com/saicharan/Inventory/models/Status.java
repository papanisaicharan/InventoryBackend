package com.saicharan.Inventory.models;

public enum Status {
	ORDERED ("Ordered"),
	READY ("Ready"),
	DELIVERED ("Delivered");
	
	private final String status;
	
	Status(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
