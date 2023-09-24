package com.astroganit.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.astroganit.api.constant.HoroscopeConstant;
import com.astroganit.api.constant.HoroscopeConstant2024;
import com.astroganit.api.constant.HoroscopeConstantEng2024;
import com.astroganit.api.payload.YearlyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect24;
import com.astroganit.api.service.YearlyHoroscopeService;
@Service
public class YearlyHoroscopeServiceImpl implements YearlyHoroscopeService {

	String [][] yearlyHoroscope= {HoroscopeConstant.ariesYH,HoroscopeConstant.taurusYH,HoroscopeConstant.geminiYH,HoroscopeConstant.cancerYH,HoroscopeConstant.leoYH,HoroscopeConstant.virgoYH,HoroscopeConstant.libraYH,HoroscopeConstant.scorpiusYH,HoroscopeConstant.sagittariusYH,HoroscopeConstant.capricornusYH,HoroscopeConstant.aquariusYH,HoroscopeConstant.piscesYH};
	String [][] yearlyHoroscope24= {HoroscopeConstant2024.ariesYH,HoroscopeConstant2024.taurusYH,HoroscopeConstant2024.geminiYH,HoroscopeConstant2024.cancerYH,HoroscopeConstant2024.leoYH,HoroscopeConstant2024.virgoYH,HoroscopeConstant2024.libraYH,HoroscopeConstant2024.scorpiusYH,HoroscopeConstant2024.sagittariusYH,HoroscopeConstant2024.capricornusYH,HoroscopeConstant2024.aquariusYH,HoroscopeConstant2024.piscesYH};
	String [][] yearlyHoroscopeEng24= {HoroscopeConstantEng2024.ariesYH,HoroscopeConstantEng2024.taurusYH,HoroscopeConstantEng2024.geminiYH,HoroscopeConstantEng2024.cancerYH,HoroscopeConstantEng2024.leoYH,HoroscopeConstantEng2024.virgoYH,HoroscopeConstantEng2024.libraYH,HoroscopeConstantEng2024.scorpiusYH,HoroscopeConstantEng2024.sagittariusYH,HoroscopeConstantEng2024.capricornusYH,HoroscopeConstantEng2024.aquariusYH,HoroscopeConstantEng2024.piscesYH};
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
	@Cacheable(cacheNames = "YearlyHoroscopeAspect24" ,key = "{#year,#langCode}")
	public List<YearlyHoroscopeAspect24> getYearlyHoroscope24(String year,String langCode) {
		List<YearlyHoroscopeAspect24> listYearlyAspect = new ArrayList<YearlyHoroscopeAspect24>();
		String [][] yearly;
		if(langCode=="" ||langCode==null) {
			langCode="2";
		}
		if(langCode.equals("1")) {
			yearly=yearlyHoroscopeEng24;
		}else {
			yearly=yearlyHoroscope24;
		}
		//"शिक्षा","विवाह","फाइनेंस","व्यापार","करियर","प्रेम","स्वास्थ्य"
		for(int i=0;i<yearly.length;i++) {
			
			YearlyHoroscopeAspect24 YHA = new YearlyHoroscopeAspect24();
			for(int j=0;j<yearly[i].length;j++) {
				
				if(j==0) {
					YHA.setEducation(yearly[i][j]);
				}
				if(j==1) {
					YHA.setMarriage(yearly[i][j]);
				}
				if(j==2) {
					YHA.setFinance(yearly[i][j]);
				}
				if(j==3) {
					YHA.setBusiness(yearly[i][j]);
				}
				if(j==4) {
					YHA.setCarrer(yearly[i][j]);
				}
				if(j==5) {
					YHA.setLove(yearly[i][j]);
				}
				if(j==6) {
					YHA.setHealth(yearly[i][j]);
				}
				if(j==7) {
					YHA.setFamily(yearly[i][j]);
				}
				
			}
			listYearlyAspect.add(YHA);
		}
		
	return listYearlyAspect;
	}

}
