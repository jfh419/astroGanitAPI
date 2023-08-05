package com.astroganit.api.service;


import java.util.List;

import com.astroganit.api.payload.DailyHoroscopeAspect;


public interface DailyHoroscopeService {

	public List<DailyHoroscopeAspect> getHoroscopeByDay(String todate);
	public List<DailyHoroscopeAspect> getHoroscopeByDayWithSenctenceId(String todate);
	
	
}
