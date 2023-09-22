package com.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomHandler {
	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request){
		List<String> details = new ArrayList();
		details.add(ex.getLocalizedMessage());
		ErrorResponse re = new ErrorResponse("OOPS..... Header is missing", details);
		
		return new ResponseEntity<Object>(re, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request){
		List<String> details = new ArrayList();
		details.add(ex.getLocalizedMessage());
		ErrorResponse re = new ErrorResponse("Server Error", details);
		
		return new ResponseEntity<Object>(re, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
