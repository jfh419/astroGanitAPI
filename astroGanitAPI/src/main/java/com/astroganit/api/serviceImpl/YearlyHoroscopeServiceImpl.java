package com.astroganit.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.astroganit.api.constant.HoroscopeConstant;
import com.astroganit.api.constant.HoroscopeConstant2024;
import com.astroganit.api.payload.YearlyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect24;
import com.astroganit.api.service.YearlyHoroscopeService;
@Service
public class YearlyHoroscopeServiceImpl implements YearlyHoroscopeService {

	String [][] yearlyHoroscope= {HoroscopeConstant.ariesYH,HoroscopeConstant.taurusYH,HoroscopeConstant.geminiYH,HoroscopeConstant.cancerYH,HoroscopeConstant.leoYH,HoroscopeConstant.virgoYH,HoroscopeConstant.libraYH,HoroscopeConstant.scorpiusYH,HoroscopeConstant.sagittariusYH,HoroscopeConstant.capricornusYH,HoroscopeConstant.aquariusYH,HoroscopeConstant.piscesYH};
	String [][] yearlyHoroscope24= {HoroscopeConstant2024.ariesYH,HoroscopeConstant2024.taurusYH,HoroscopeConstant2024.geminiYH,HoroscopeConstant2024.cancerYH,HoroscopeConstant2024.leoYH,HoroscopeConstant2024.virgoYH,HoroscopeConstant2024.libraYH,HoroscopeConstant2024.scorpiusYH,HoroscopeConstant2024.sagittariusYH,HoroscopeConstant2024.capricornusYH,HoroscopeConstant2024.aquariusYH,HoroscopeConstant2024.piscesYH};
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

	@Override
	@Cacheable(cacheNames = "YearlyHoroscopeAspect24" ,key = "#year")
	public List<YearlyHoroscopeAspect24> getYearlyHoroscope24(String year) {
		List<YearlyHoroscopeAspect24> listYearlyAspect = new ArrayList<YearlyHoroscopeAspect24>();
		//"शिक्षा","विवाह","फाइनेंस","व्यापार","करियर","प्रेम","स्वास्थ्य"
		for(int i=0;i<yearlyHoroscope24.length;i++) {
			
			YearlyHoroscopeAspect24 YHA = new YearlyHoroscopeAspect24();
			for(int j=0;j<yearlyHoroscope24[i].length;j++) {
				
				if(j==0) {
					YHA.setEducation(yearlyHoroscope24[i][j]);
				}
				if(j==1) {
					YHA.setMarriage(yearlyHoroscope24[i][j]);
				}
				if(j==2) {
					YHA.setFinance(yearlyHoroscope24[i][j]);
				}
				if(j==3) {
					YHA.setBusiness(yearlyHoroscope24[i][j]);
				}
				if(j==4) {
					YHA.setCarrer(yearlyHoroscope24[i][j]);
				}
				if(j==5) {
					YHA.setLove(yearlyHoroscope24[i][j]);
				}
				if(j==6) {
					YHA.setHealth(yearlyHoroscope24[i][j]);
				}
				if(j==7) {
					YHA.setFamily(yearlyHoroscope24[i][j]);
				}
				
			}
			listYearlyAspect.add(YHA);
		}
		
	return listYearlyAspect;
	}

}
