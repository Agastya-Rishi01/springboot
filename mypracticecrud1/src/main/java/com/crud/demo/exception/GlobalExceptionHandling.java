package com.crud.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.crud.demo.custom.messagebeans.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleresourcenotfound(ResourceNotFoundException r, WebRequest webRequest)
	{
		ErrorMessage em=new ErrorMessage(r.getMessage()+" "+webRequest.toString(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(em,HttpStatus.NOT_FOUND);
	}
	
	
}
