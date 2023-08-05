package com.astroganit.api.service;

import java.util.List;

import com.astroganit.api.payload.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getallUsers();
	
	void deleteUser(Integer userId);
}
