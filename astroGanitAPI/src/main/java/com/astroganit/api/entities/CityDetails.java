package com.astroganit.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String place;
	
	private String latitude;
	
	@Column(name = "lat_deg")
	private String latDeg;
	
	@Column(name = "lat_min")
	private String latMin;
	
	@Column(name = "lat_ns")
	private String latNS;
	
	private String longitude;
	
	@Column(name = "long_deg")
	private String longDeg;
	
	@Column(name = "long_min")
	private String longMin;
	
	@Column(name = "long_ew")
	private String longEW;
	
	private String state;
	
	private String country;
	
	private String timezone;
	
	@Column(name = "timezone_string")
	private String timezoneStr;
}
