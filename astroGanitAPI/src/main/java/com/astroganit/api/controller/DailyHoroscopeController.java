package com.astroganit.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astroganit.api.payload.DailyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect;
import com.astroganit.api.payload.YearlyHoroscopeAspect24;
import com.astroganit.api.service.DailyHoroscopeService;
import com.astroganit.api.service.YearlyHoroscopeService;

@RestController
@RequestMapping("/api")
public class DailyHoroscopeController {
	@Autowired
	private DailyHoroscopeService dailyService;
	@Autowired
	private YearlyHoroscopeService yearlyService;
		
	@GetMapping("/dailyhoroscope/{day}/{langCode}")
	public ResponseEntity<List<DailyHoroscopeAspect>>  getDailyRashifal(@PathVariable("day") String day,@PathVariable("langCode") String langCode) {
		LocalDate myDateObj = LocalDate.now().plusDays(Integer.parseInt(day));
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy");
	    String formattedDate = myDateObj.format(myFormatObj);

	    String todate=formattedDate;
	    
	    List<DailyHoroscopeAspect> dh =this.dailyService.getHoroscopeByDay(todate,langCode);
				 
	        if (dh==null){
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(dh);
	}
	
	@GetMapping("/dailyhoroscope1/{day}/{langCode}")
	public ResponseEntity<List<DailyHoroscopeAspect>>  getDailyRashifal1(@PathVariable("day") String day,@PathVariable("langCode") String langCode) {
		LocalDate myDateObj = LocalDate.now().plusDays(Integer.parseInt(day));
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy");
	    String formattedDate = myDateObj.format(myFormatObj);

	    String todate=formattedDate;
	    
	    List<DailyHoroscopeAspect> dh =this.dailyService.getHoroscopeByDayWithSenctenceId(todate);
				 
	        if (dh==null){
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(dh);
	}
	
	@GetMapping("/yearlyHoroscope/{langCode}")
	public ResponseEntity<List<YearlyHoroscopeAspect>> getYearlyHoroscope(@PathVariable("langCode") String langCode){
		String cYear = "2023";
		List<YearlyHoroscopeAspect> yearlyHoroscope = this.yearlyService.getYearlyHoroscope(cYear);
		if(yearlyHoroscope==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(yearlyHoroscope);
	}
	
	@GetMapping("/yearlyHoroscope24/{langCode}")
	public ResponseEntity<List<YearlyHoroscopeAspect24>> getYearlyHoroscope24(@PathVariable("langCode") String langCode){
		String cYear = "2024";
		List<YearlyHoroscopeAspect24> yearlyHoroscope = this.yearlyService.getYearlyHoroscope24(cYear,langCode);
		if(yearlyHoroscope==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(yearlyHoroscope);
	}
	
}
