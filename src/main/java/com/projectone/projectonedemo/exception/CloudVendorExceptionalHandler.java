package com.projectone.projectonedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionalHandler {
	
	@ExceptionHandler(value = {CloudVendorNotFoundException.class})
	public ResponseEntity<Object> handleCloudVendorNotFoundException
	(CloudVendorNotFoundException cloudVendorNotFoundException) 
	{
		ClouVendorException clouVendorException = new ClouVendorException
				(
						cloudVendorNotFoundException.getMessage(),
						cloudVendorNotFoundException.getCause(),
						HttpStatus.NOT_FOUND
						);
		return new ResponseEntity<>(clouVendorException, HttpStatus.NOT_FOUND);
		
		
		
		
	}

}
