package com.astroganit.api.payload;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OTPDto {

	int id;
	
	String otp;
	
	String mobile;
	
	@JsonProperty
	private Date createdDate;
	
	@JsonProperty
	private Date updatedDate;
	
	private int count;
	
}
