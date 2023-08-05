package com.astroganit.api.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NumerologyDto {

	private int day;
	private int month;
	private int year;
	private String name;
	//ctype = {cheiro(0), sepherial(1), modern(2), pythagorian(3)};
	private int type;
	private int langCode;
	
}
