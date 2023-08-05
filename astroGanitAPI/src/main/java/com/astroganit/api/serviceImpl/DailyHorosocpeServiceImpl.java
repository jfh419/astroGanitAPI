package com.astroganit.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.astroganit.api.payload.DailyHoroscopeAspect;

import com.astroganit.api.payload.DailyHorosocpeSentence;
import com.astroganit.api.repository.DailHoroscopeRepository;
import com.astroganit.api.service.DailyHoroscopeService;
import com.astroganit.api.util.DailyHoroUtil;


@Service
public class DailyHorosocpeServiceImpl implements DailyHoroscopeService {
	
	@Autowired
	private DailHoroscopeRepository dailyRepo;
	
	@Override
	@Cacheable(cacheNames = "DailyHoroscopeRashi" ,key = "#todate")
	public List<DailyHoroscopeAspect> getHoroscopeByDay(String todate) {
		// TODO Auto-generated method stub
		System.out.println("fetching the details from db");
		Random rand ; 
		//String aspectName []= {"love","wealth","family","carrer","health"};
		//total number of aspect in db of horoscope
		int arrAspect []= {1,2,3,4,5};
		//total number of sentences for particular sequence number
		int arrSequenceId []= {75,137,124,107,54,51,51,96,103,79,51,55,68,156,140,95,51,51,51,117,173,99,51,51,51,69,90,106,51,51};
		
		// dayvalue 0 means today ,1 means tomorrow, -1 means yesterday
				
		double julianNumber=DailyHoroUtil.getJulianDay(todate);
		
		int totalRashi = 12;
		List<DailyHoroscopeAspect> listAspect = new ArrayList<DailyHoroscopeAspect>();
		for (int rashi=1; rashi<=totalRashi;rashi++) {
				
			
			DailyHoroscopeAspect DHA = new DailyHoroscopeAspect();
			
				int number=0;
				for (int aspect=0;aspect< arrAspect.length; aspect++) {
					int sequenceNo=0;
					
					double uniqueNumber=julianNumber*arrAspect[aspect]*rashi;
					
					rand = new Random((long) uniqueNumber); 
					 
					int rating = rand.nextInt(6 - 1 + 1) + 1;
					
					sequenceNo=sequenceNo+(6-rating)+number; // (6-rating) means rating is descending order in table
					number = number+6; // to get other aspect number
					int sentenceCount = arrSequenceId[sequenceNo];
					int sentenceId=rand.nextInt(sentenceCount); 
					
										
					DailyHorosocpeSentence dailyHoro=this.dailyRepo.getSentence(sequenceNo, sentenceId);
					
					if(aspect==0) {
						DHA.setLove(dailyHoro.getSentence());
						
					}
					if(aspect==1) {
						DHA.setWealth(dailyHoro.getSentence());
						
					}
					if(aspect==2) {
						DHA.setFamily(dailyHoro.getSentence());
						
					}
					if(aspect==3) {
						DHA.setCarrer(dailyHoro.getSentence());
						
					}
					if(aspect==4) {
						DHA.setHealth(dailyHoro.getSentence());
						
					}
					
				}//aspect for loop end 
				double luckyNumber=julianNumber*rashi;
				Random rand1 = new Random((long) luckyNumber); 
				int lNumber = rand1.nextInt(9) + 1;
				DHA.setLuckyNumber(lNumber);
								
				listAspect.add(DHA);
		}//end rashi for loop

		return listAspect;
	}

	@Override
	@Cacheable(cacheNames = "DailyHoroscopeRashiWithSentenctId" ,key = "#todate")
	public List<DailyHoroscopeAspect> getHoroscopeByDayWithSenctenceId(String todate) {
		// TODO Auto-generated method stub
		System.out.println("fetching the details from db with sentence id and sq no");
		Random rand ; 
		//String aspectName []= {"love","wealth","family","carrer","health"};
		//total number of aspect in db of horoscope
		int arrAspect []= {1,2,3,4,5};
		//total number of sentences for particular sequence number
		int arrSequenceId []= {75,137,124,107,54,51,51,96,103,79,51,55,68,156,140,95,51,51,51,117,173,99,51,51,51,69,90,106,51,51};
		
		// dayvalue 0 means today ,1 means tomorrow, -1 means yesterday
				
		double julianNumber=DailyHoroUtil.getJulianDay(todate);
		
		int totalRashi = 12;
		List<DailyHoroscopeAspect> listAspect = new ArrayList<DailyHoroscopeAspect>();
		for (int rashi=1; rashi<=totalRashi;rashi++) {
				
			
			DailyHoroscopeAspect DHA = new DailyHoroscopeAspect();
			
				int number=0;
				for (int aspect=0;aspect< arrAspect.length; aspect++) {
					int sequenceNo=0;
					
					double uniqueNumber=julianNumber*arrAspect[aspect]*rashi;
					
					rand = new Random((long) uniqueNumber); 
					 
					int rating = rand.nextInt(6 - 1 + 1) + 1;
					
					sequenceNo=sequenceNo+(6-rating)+number; // (6-rating) means rating is descending order in table
					number = number+6; // to get other aspect number
					int sentenceCount = arrSequenceId[sequenceNo];
					int sentenceId=rand.nextInt(sentenceCount); 
					
										
					DailyHorosocpeSentence dailyHoro=this.dailyRepo.getSentence(sequenceNo, sentenceId);
					
					if(aspect==0) {
						DHA.setLove("SentenceId ="+sentenceId+" SequenceNo="+sequenceNo+"  -> "+dailyHoro.getSentence());
						
					}
					if(aspect==1) {
						DHA.setWealth("SentenceId ="+sentenceId+" SequenceNo="+sequenceNo+"  -> "+dailyHoro.getSentence());
						
					}
					if(aspect==2) {
						DHA.setFamily("SentenceId ="+sentenceId+" SequenceNo="+sequenceNo+"  -> "+dailyHoro.getSentence());
						
					}
					if(aspect==3) {
						DHA.setCarrer("SentenceId ="+sentenceId+" SequenceNo="+sequenceNo+"  -> "+dailyHoro.getSentence());
						
					}
					if(aspect==4) {
						DHA.setHealth("SentenceId ="+sentenceId+" SequenceNo="+sequenceNo+"  -> "+dailyHoro.getSentence());
						
					}
					
				}//aspect for loop end 
				double luckyNumber=julianNumber*rashi;
				Random rand1 = new Random((long) luckyNumber); 
				int lNumber = rand1.nextInt(9) + 1;
				DHA.setLuckyNumber(lNumber);
								
				listAspect.add(DHA);
		}//end rashi for loop

		return listAspect;
	}
	
}
