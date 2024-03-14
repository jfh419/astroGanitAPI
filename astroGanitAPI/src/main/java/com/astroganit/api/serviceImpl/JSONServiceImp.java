package com.astroganit.api.serviceImpl;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.astroganit.api.payload.Response;
import com.astroganit.api.service.JSONService;
import com.astroganit.api.util.HUtil;

@Service
public class JSONServiceImp implements JSONService{

	@Override
	@Cacheable(cacheNames = "BaalKandBySlok" ,key = "#sId")
	public Response getBaalKandBySlok(String sId) {
		// TODO Auto-generated method stub
		Response response = new Response();
		
		int id = HUtil.strToInt(sId);
		String path="src/main/resources/json/baalkand/bk"+id+".json";
		String file="";
		try {
			file = HUtil.readFile(path);
			response.setResultCode(1);
			response.setMessage("");
			response.setErrorMessage("");
			response.setStatus(HttpStatus.OK);
			response.setData(Arrays.asList(file));
			
		} catch (IOException e) {
			response.setResultCode(0);
			response.setMessage("getting exception while getting the json on given slok number");
			response.setErrorMessage(e.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setData(Arrays.asList());
		}
		
		return response;
	}

}
