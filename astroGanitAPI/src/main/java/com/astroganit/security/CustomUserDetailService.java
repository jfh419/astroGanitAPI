package com.astroganit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.astroganit.api.entities.User;
import com.astroganit.api.exception.ResourceNotFoundException;
import com.astroganit.api.repository.UserRepo;

@Service
public class CustomUserDetailService  implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from database by username
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(()->new ResourceNotFoundException("user", "email: "+username,0));
				
		return (UserDetails) user;
	}

}
