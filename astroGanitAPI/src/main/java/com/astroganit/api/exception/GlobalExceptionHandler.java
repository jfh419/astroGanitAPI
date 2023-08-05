package com.astroganit.api.exception;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.astroganit.api.payload.ApiResponse;
import com.astroganit.api.payload.Response;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String ,String> response= new HashMap();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Response> numberFormatExceptionHandler(NumberFormatException ex) {
		ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST,ex.getMessage() ,ex);
		Response res = new Response();
		res.setData(Arrays.asList());
		res.setErrorMessage(ex.getMessage());
		res.setStatus(HttpStatus.BAD_REQUEST);
		res.setResultCode(0);
		res.setMessage("");
		return new ResponseEntity<Response>(res,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response> resourceNotFoundException(ResourceNotFoundException ex){
		//ApiResponse response = new ApiResponse(HttpStatus.NOT_FOUND,ex.getMessage(),ex);
		Response res = new Response();
		res.setData(Arrays.asList());
		res.setErrorMessage(ex.getMessage());
		res.setStatus(HttpStatus.NOT_FOUND);
		res.setResultCode(0);
		res.setMessage("");
		return new ResponseEntity<Response>(res,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(UsernamePasswordException.class)
	public ResponseEntity<Response> usernamePasswordException(UsernamePasswordException ex){
		//ApiResponse response = new ApiResponse(HttpStatus.NOT_FOUND,ex.getMessage(),ex);
		Response res = new Response();
		res.setData(Arrays.asList());
		res.setErrorMessage(ex.getMessage());
		res.setStatus(HttpStatus.NOT_FOUND);
		res.setResultCode(0);
		res.setMessage("");
		return new ResponseEntity<Response>(res,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		//ApiResponse response = new ApiResponse(status,ex.getMessage(),ex);
		Response res = new Response();
		res.setData(Arrays.asList());
		res.setErrorMessage(ex.getMessage());
		res.setStatus(HttpStatus.METHOD_NOT_ALLOWED);
		res.setResultCode(0);
		res.setMessage("");
		return new ResponseEntity<Object>(res,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
	
}
