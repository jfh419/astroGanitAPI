package com.astroganit.api.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.astroganit.api.constant.SuvicharConstant;
import com.astroganit.api.exception.ResourceNotFoundException;
import com.astroganit.api.payload.Response;
import com.astroganit.api.payload.SuvicharDto;
import com.astroganit.api.payload.SuvicharURL;
import com.astroganit.api.service.SuvicharService;

@Service
public class SuvicharServiceImp implements SuvicharService{

	
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
		System.out.println("in side method");
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
}
