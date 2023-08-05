package com.astroganit.api.payload;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Response {

	private String message ;
	private int resultCode;
	private String errorMessage;
	private HttpStatus status;
	private List data;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String message, int resultCode, String errorMessage, HttpStatus status, List data) {
		super();
		this.message = message;
		this.resultCode = resultCode;
		this.errorMessage = errorMessage;
		this.status = status;
		this.data = data;
	}
	public Response(String message, int resultCode, List data) {
		super();
		this.message = message;
		this.resultCode = resultCode;
		this.data = data;
	}
	public Response(int resultCode, String errorMessage, HttpStatus status) {
		super();
		this.resultCode = resultCode;
		this.errorMessage = errorMessage;
		this.status = status;
	}
	public Response(int resultCode, Throwable ex) {
	       this();
	       this.resultCode = resultCode;
	       this.errorMessage = ex.getLocalizedMessage();
	   }
	
	public Response(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.errorMessage = ex.getLocalizedMessage();
	   }
	
}
