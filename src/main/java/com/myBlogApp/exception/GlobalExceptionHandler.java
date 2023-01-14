package com.myBlogApp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myBlogApp.payloads.MyErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class )
	public ResponseEntity<MyErrorDetails> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		
		 MyErrorDetails errorDetails = new MyErrorDetails(message, false, LocalDateTime.now());
		 return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
}
