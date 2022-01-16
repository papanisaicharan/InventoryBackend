package com.saicharan.Inventory.exceptions;

public class GenericException extends RuntimeException{
	
	private String exceptionLabel;
	public GenericException(String msg, String exceptionLabel) {
	    super(msg);
	    this.exceptionLabel = exceptionLabel;
	}
	
	public GenericException() {}

	public String getExceptionLabel() {
		return exceptionLabel;
	}

	public void setExceptionLabel(String exceptionLabel) {
		this.exceptionLabel = exceptionLabel;
	}
	
	

}
