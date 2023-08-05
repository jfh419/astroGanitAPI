package com.astroganit.api.service;


import java.util.List;

import com.astroganit.api.payload.DailyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect;


public interface YearlyHoroscopeService {

	public List<YearlyHoroscopeAspect> getYearlyHoroscope(String year);
	
}
