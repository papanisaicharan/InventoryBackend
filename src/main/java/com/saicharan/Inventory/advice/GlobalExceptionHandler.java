package com.saicharan.Inventory.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.saicharan.Inventory.exceptions.GenericException;
import com.saicharan.Inventory.models.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {GenericException.class})
	public ResponseEntity<Object> dataNotFound(GenericException genericException, WebRequest request){
		ErrorMessage message = new ErrorMessage(
				HttpStatus.NOT_FOUND.value(),
		        new Date(),
		        genericException.getMessage(),
		        request.getDescription(false),
		        genericException.getExceptionLabel());
		return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
	}

}
