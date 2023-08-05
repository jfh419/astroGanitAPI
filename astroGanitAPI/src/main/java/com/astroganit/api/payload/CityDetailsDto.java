package com.astroganit.api.payload;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CityDetailsDto {

	private int id ;
	
	private String place;
			
	private String latDeg;
	
	private String latMin;
	
	private String latNS;
	
	private String longDeg;
	
	private String longMin;
	
	private String longEW;
	
	private String state;
	
	private String country;
	
	private String timezone;
	
	private String timezoneStr;
}
