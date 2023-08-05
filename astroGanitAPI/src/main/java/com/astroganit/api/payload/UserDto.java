package com.astroganit.api.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@NotNull
	@Size(min = 4,message = "user name must be min of 4 char !!")
	private String name;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min = 3,max = 10,message = "min 3 and max 10 character !!")
	private String password;
	
	@NotNull
	private String about;
	
	@JsonProperty
	@NotNull
	@NotEmpty
	private boolean userActive;
	
	@JsonProperty
	private Date createdDate;
	
	@JsonProperty
	private Date updatedDate;
	
	private Set<RoleDto> roles = new HashSet<>();
	
}
