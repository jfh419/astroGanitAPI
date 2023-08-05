package com.astroganit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astroganit.api.exception.UsernamePasswordException;
import com.astroganit.api.payload.JwtAuthRequest;
import com.astroganit.api.payload.JwtAuthResponse;
import com.astroganit.api.payload.UserDto;
import com.astroganit.api.service.UserService;
import com.astroganit.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/ganit/v1/auth")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private AuthenticationManager authenticationManger;
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
	
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetails = this.userDetailService.loadUserByUsername(request.getUsername());
		
		String generateToken = this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(generateToken);
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}
	
	
	public void authenticate(String username,String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			this.authenticationManger.authenticate(authenticationToken);
		}
		catch (DisabledException e) {
			throw new UsernamePasswordException(username, password, "USER_DISABLED");
		}
		catch (BadCredentialsException e) {
			System.out.println("invalid userid or  password !!");
			throw new UsernamePasswordException(username, password, "Bad Crendential");
		}
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/register")
	public ResponseEntity<UserDto> registeredNewUser(@RequestBody UserDto userDto){
		UserDto registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
	}
	
}
