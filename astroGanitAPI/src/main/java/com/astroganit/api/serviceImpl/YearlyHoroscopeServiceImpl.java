package com.astroganit.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.astroganit.api.constant.HoroscopeConstant;

import com.astroganit.api.payload.YearlyHoroscopeAspect;
import com.astroganit.api.service.YearlyHoroscopeService;
@Service
public class YearlyHoroscopeServiceImpl implements YearlyHoroscopeService {

	String [][] yearlyHoroscope= {HoroscopeConstant.ariesYH,HoroscopeConstant.taurusYH,HoroscopeConstant.geminiYH,HoroscopeConstant.cancerYH,HoroscopeConstant.leoYH,HoroscopeConstant.virgoYH,HoroscopeConstant.libraYH,HoroscopeConstant.scorpiusYH,HoroscopeConstant.sagittariusYH,HoroscopeConstant.capricornusYH,HoroscopeConstant.aquariusYH,HoroscopeConstant.piscesYH};
	
	@Override
	@Cacheable(cacheNames = "YearlyHoroscopeAspect" ,key = "#year")
	public List<YearlyHoroscopeAspect> getYearlyHoroscope(String year) {
		
		List<YearlyHoroscopeAspect> listYearlyAspect = new ArrayList<YearlyHoroscopeAspect>();
		
		for(int i=0;i<yearlyHoroscope.length;i++) {
			
			YearlyHoroscopeAspect YHA = new YearlyHoroscopeAspect();
			for(int j=0;j<yearlyHoroscope[i].length;j++) {
				
				if(j==0) {
					YHA.setLove(yearlyHoroscope[i][j]);
				}
				if(j==1) {
					YHA.setWealth(yearlyHoroscope[i][j]);
				}
				if(j==2) {
					YHA.setCarrer(yearlyHoroscope[i][j]);
				}
				if(j==3) {
					YHA.setFamily(yearlyHoroscope[i][j]);
				}
				if(j==4) {
					YHA.setHealth(yearlyHoroscope[i][j]);
				}
				if(j==5) {
					YHA.setMarriage(yearlyHoroscope[i][j]);
				}
				
			}
			listYearlyAspect.add(YHA);
		}
		
	return listYearlyAspect;
	}

}
