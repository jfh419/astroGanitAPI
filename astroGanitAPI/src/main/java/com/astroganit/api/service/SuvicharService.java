package com.astroganit.api.service;

import com.astroganit.api.payload.Response;
import com.astroganit.api.payload.SuvicharDto;

public interface SuvicharService {

	Response getSuvichar(int id,int langCode);
	
	Response getAllSuvichar(int langCode);
	
	Response getAllSuvicharURL(int langCode);
	
	Response getSuvicharByIds(String dayNightValue,String daysValue,String langCode);
	
}
