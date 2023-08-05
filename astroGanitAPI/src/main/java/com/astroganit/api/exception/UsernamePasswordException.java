package com.astroganit.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsernamePasswordException extends RuntimeException {

	String username;
	String password;
	String error;
	public UsernamePasswordException(String username, String password, String error) {
		super(String.format("%s For username -> %s and password -> %s ",error,username,password));
		this.username = username;
		this.password = password;
		this.error = error;
	}
	
	
	
	
}
