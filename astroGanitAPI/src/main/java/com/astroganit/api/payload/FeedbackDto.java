package com.astroganit.api.payload;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FeedbackDto {

	private int id;
	
	private String name;
	
	private String email;
	
	private long mobileNumber;
	
	private String message;
	
	private Date createdDate;

}
