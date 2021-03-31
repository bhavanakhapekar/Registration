package com.example.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	String message;
	HttpStatus status;
	LocalDateTime timestamp;
	List<String> details;
	Map<String, String> error;
	public ApiErrors() {
		super();
	}
	
	
	

	public ApiErrors(String message, HttpStatus status, LocalDateTime timestamp, Map<String, String> error) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public HttpStatus getStatus() {
		return status;
	}
	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	

	@Override
	public String toString() {
		return "ApiErrors [message=" + message + ", status=" + status + ", timestamp=" + timestamp + ", error=" + error
				+ "]";
	}
	
}