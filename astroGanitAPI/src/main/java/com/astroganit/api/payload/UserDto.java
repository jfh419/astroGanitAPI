package com.astroganit.api.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
	@Size(min = 3,message = "user name must be min of 3 char !!")
	private String name;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
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
	
	
	private String dcrptpassword;
	
	
	private String gender;
	
	
	private String place;
	
	private String country;
	
	private String state;
	
	private String mobile;
	
	private String mobilecc;//mobile country code
	
	@JsonProperty
	private String dayBirth;
	
	@JsonProperty
	private String monthBirth;
	
	@JsonProperty
	private String yearBirth;
	
	@JsonProperty
	private String hourBirth;
	
	@JsonProperty
	private String minuteBirth;
	
	@JsonProperty
	private String secondBirth;
	
	private String latitude;
	
	@JsonProperty
	private String latDeg;
	
	@JsonProperty
	private String latMin;
	
	@JsonProperty
	private String latNS;
	
	@JsonProperty
	private String longitude;
	
	@JsonProperty
	private String longDeg;
	
	@JsonProperty
	private String longMin;
	
	@JsonProperty
	private String longEW;
	
	@JsonProperty
	private String timeZone;
	
	@JsonProperty
	private boolean userVerified;
	
	@JsonProperty
	private String maritalStatus;
	
	@JsonProperty
	private String deviceId;
	
	@JsonProperty
	private String appVersion;
	
	@JsonProperty
	private String androidVersion;
	
}
