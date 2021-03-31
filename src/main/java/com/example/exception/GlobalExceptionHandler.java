package com.example.exception;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.model.ApiErrors;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
		
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
    	    	
    	HashMap<String, String> errors = new HashMap<String, String>();
    	for(FieldError error:ex.getFieldErrors()) {
			System.out.println(error);
			errors.put(error.getField(),error.getDefaultMessage());
		}			
				
		 ApiErrors error = new ApiErrors("Validation Failed",HttpStatus.BAD_REQUEST,LocalDateTime.now(),errors);
	     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
