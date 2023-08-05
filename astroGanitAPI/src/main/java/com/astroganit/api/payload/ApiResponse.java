package com.astroganit.api.payload;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiResponse {

	private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   
	   
	   public ApiResponse(HttpStatus status, LocalDateTime timestamp, String message, String debugMessage) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.debugMessage = debugMessage;
	}

	   public  ApiResponse() {
	       timestamp = LocalDateTime.now();
	   }

	   public ApiResponse(HttpStatus status) {
	       this();
	       this.status = status;
	   }
	   public ApiResponse(String message) {
	       this();
	       this.message = message;
	   }
	   public ApiResponse(String message , Throwable ex) {
	       this();
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	   public ApiResponse(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   public ApiResponse(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	public HttpStatus getStatus() {
		return status;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	   
	   
	
	
}

