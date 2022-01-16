package com.saicharan.Inventory.models;

import java.util.Date;

public class ErrorMessage {
	
	private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;
	  private String exceptionLabel;
	public ErrorMessage(int statusCode, Date timestamp, String message, String description, String exceptionLabel) {
		super();
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
		this.exceptionLabel = exceptionLabel;
	}
	public ErrorMessage() {}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExceptionLabel() {
		return exceptionLabel;
	}
	public void setExceptionLabel(String exceptionLabel) {
		this.exceptionLabel = exceptionLabel;
	}
	  
	  
}
