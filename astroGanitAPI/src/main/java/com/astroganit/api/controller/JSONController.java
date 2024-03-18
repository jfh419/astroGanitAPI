package com.astroganit.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astroganit.api.payload.Response;
import com.astroganit.api.service.JSONService;


@RestController
@RequestMapping("/api/json")
public class JSONController {

	@Autowired
	private JSONService jsonService; 
	
	@GetMapping("/baalkand/{sId}")
	public ResponseEntity<Response> baalKandBySlok(@PathVariable String sId){
		
		Response baalKandBySlok = this.jsonService.getBaalKandBySlok(sId);
		
		return ResponseEntity.ok(baalKandBySlok);
	}
	
}
