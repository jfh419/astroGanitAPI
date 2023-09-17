package com.astroganit.api.service;


import java.util.List;

import com.astroganit.api.payload.DailyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect24;


public interface YearlyHoroscopeService {

	public List<YearlyHoroscopeAspect> getYearlyHoroscope(String year);
	
	public List<YearlyHoroscopeAspect24> getYearlyHoroscope24(String year);
	
}
