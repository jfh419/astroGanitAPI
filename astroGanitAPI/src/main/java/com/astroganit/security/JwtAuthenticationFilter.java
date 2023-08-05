package com.astroganit.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private JwtTokenHelper jstTokenHelper;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		
		//1 get token
		String requestToken = request.getHeader("Authorization");
		//Bearer 235234safd
		System.out.println("requestToken -> "+requestToken);
		
		String username=null;
		
		String token=null;
		
		if(requestToken!=null && requestToken.startsWith("Bearer")) {
			 token = requestToken.substring(7);
			 try {
				 username=this.jstTokenHelper.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("unable to get jwt token");
			}
			 catch(ExpiredJwtException e) {
				 System.out.println("jwt token has expired");
			 }
			 catch(MalformedJwtException e) {
				 System.out.println("Invalid jwt");
			 }
			 
			 
		}
		else {
			System.out.println("jwt token does not begin with bearer or requestToken is null");
		}
		//once we get the token, now validate		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails= this.userDetailService.loadUserByUsername(username);
			if(this.jstTokenHelper.validateToken(token, userDetails)) {
				//authentication krna h
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()); 
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				System.out.println("token generated successfully");
			}else {
				System.out.println("invalid jwt token");
			}
		}
		else {
			System.out.println("username is null or context is null");
		}
		filterChain.doFilter(request,response);
	
	}

}
