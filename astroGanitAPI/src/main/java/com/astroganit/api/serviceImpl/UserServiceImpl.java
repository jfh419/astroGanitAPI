 package com.astroganit.api.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.astroganit.api.constant.AppConstant;
import com.astroganit.api.entities.Role;
import com.astroganit.api.entities.User;
import com.astroganit.api.exception.ResourceNotFoundException;
import com.astroganit.api.payload.UserDto;
import com.astroganit.api.repository.RoleRepo;
import com.astroganit.api.repository.UserRepo;
import com.astroganit.api.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		user.setCreatedDate(new Date());
		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		//get role
		Role role = this.roleRepo.findById(AppConstant.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepo.save(user);
		return this.modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		user.setUserActive(userDto.isUserActive());
		user.setUpdatedDate(new Date());
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.modelMapper.map(updateUser, UserDto.class);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getallUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDto=users.stream().map(user->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "id", userId));
		user.getRoles().clear();
		this.userRepo.delete(user);
	}

	
	
}
