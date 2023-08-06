package com.astroganit.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Suvichar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String url;
	
	private String dayNight; //day=1 and night=2
	
	private String dayValue; //mon=1,tue=2,wed=3,thur=4,fri=5,sat=6,sun=7
	
	private String godNameCode;
	
	private int langCode;
	
	
}
