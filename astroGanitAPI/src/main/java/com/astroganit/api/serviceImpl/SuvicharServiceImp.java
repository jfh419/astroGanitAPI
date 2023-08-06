package com.astroganit.api.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.astroganit.api.constant.SuvicharConstant;
import com.astroganit.api.entities.Suvichar;
import com.astroganit.api.exception.ResourceNotFoundException;
import com.astroganit.api.payload.Response;
import com.astroganit.api.payload.SuvicharDto;
import com.astroganit.api.payload.SuvicharURL;
import com.astroganit.api.repository.SuvicharRepo;
import com.astroganit.api.service.SuvicharService;

@Service
public class SuvicharServiceImp implements SuvicharService{

	//langcode =2 means hindi
	
	@Autowired
	private SuvicharRepo su;
	
	@Override
	@Cacheable(cacheNames = "suvichar",key = "{#id,#langCode}")
	public Response getSuvichar(int id,int langCode) {
		
		String su="";
		if(langCode==2) {
			su=Optional.ofNullable(SuvicharConstant.getSuvicharHindi().get(id)).orElseThrow(()->new ResourceNotFoundException("Suvichar", "id - "+id+" or langCode - "+langCode, id));	
		}else {
			su=Optional.ofNullable(SuvicharConstant.getSuvicharHindi().get(id)).orElseThrow(()->new ResourceNotFoundException("Suvichar", "id - "+id+" or langCode - "+langCode, id));
		}
		SuvicharDto suvicharDto=new SuvicharDto();
		suvicharDto.setId(id);
		suvicharDto.setSentence(su);
		
		Response response = new Response();
		response.setResultCode(1);
		response.setMessage("");
		response.setErrorMessage("");
		response.setStatus(HttpStatus.OK);
		response.setData(Arrays.asList(suvicharDto));
		
		return response;
	}

	@Override
	@Cacheable(cacheNames = "allSuvichar",key = "{#langCode}")
	public Response getAllSuvichar(int langCode) {
		System.out.println("in side method");
		Map<Integer,String> suvicharHindi=null;
		if(langCode==2) {
			suvicharHindi = SuvicharConstant.getSuvicharHindi();		
		}else {
			suvicharHindi = SuvicharConstant.getSuvicharHindi();
		}
		
		Response response = new Response();
		List<SuvicharDto> list = suvicharHindi.entrySet().stream().map(e-> new SuvicharDto(e.getKey(), e.getValue())).collect(Collectors.toList());
		response.setData(list);
		response.setResultCode(1);
		response.setMessage("");
		response.setErrorMessage("");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	@Cacheable(cacheNames = "allSuvicharUrl",key = "{#langCode}")
	public Response getAllSuvicharURL(int langCode) {
		
		Map<Integer,String> suvicharHindi=null;
		
		if(langCode==2) {
			suvicharHindi = SuvicharConstant.getSuvicharHindiURL();		
		}else {
			suvicharHindi = SuvicharConstant.getSuvicharHindiURL();
		}
		
		Response response = new Response();
		List<SuvicharURL> list = suvicharHindi.entrySet().stream().map(e-> new SuvicharURL(e.getKey(), e.getValue())).collect(Collectors.toList());
		response.setData(list);
		response.setResultCode(1);
		response.setMessage("");
		response.setErrorMessage("");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}

	@Override
	public Response getSuvicharByIds(String dayNightValue, String daysValue, String langCode) {
		// TODO Auto-generated method stub
		if(dayNightValue==null || dayNightValue.isEmpty()) {
			dayNightValue="1";
		}
		else if(!dayNightValue.equals("1") && !dayNightValue.equals("2")) {
			dayNightValue="1";
		}
		
		if(daysValue==null || daysValue.isEmpty()) {
			daysValue="1";			
		}
		else if(!daysValue.equals("1") && !daysValue.equals("2") && !daysValue.equals("3") && !daysValue.equals("4") && !daysValue.equals("5") && !daysValue.equals("6") && !daysValue.equals("7") && !daysValue.equals("8") ) {
			daysValue="1";
		}
		
		if(langCode==null || langCode.isEmpty()) {
			langCode="2";			
		}
		else if(!langCode.equals("2")) {
			langCode="2";
		}
		
		System.out.println(dayNightValue + " and " +daysValue);
		Response response = new Response();
		List<Suvichar> urlList = this.su.getURL(dayNightValue, daysValue, langCode);
		
		response.setData(urlList);
		response.setResultCode(1);
		response.setMessage("");
		response.setErrorMessage("");
		response.setStatus(HttpStatus.OK);
		
		return response;
	}
}
