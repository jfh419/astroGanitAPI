package com.astroganit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astroganit.api.payload.Response;
import com.astroganit.api.payload.SuvicharDto;
import com.astroganit.api.service.SuvicharService;

@RestController
@RequestMapping("/api")
public class SuvicharController {
	
	@Autowired
	private SuvicharService suService;
	
	@GetMapping("/suvichar/{id}/{langCode}")
	public ResponseEntity<Response> getSuvichar(@PathVariable int id,@PathVariable int langCode){
		
		return ResponseEntity.ok(this.suService.getSuvichar(id,langCode));
	}
	
	@GetMapping("/suvichar/{langCode}")
	public ResponseEntity<Response> getAllSuvichar(@PathVariable int langCode){
		
		return ResponseEntity.ok(this.suService.getAllSuvichar(langCode));
	}
	
	@GetMapping("/suvicharurl/{langCode}")
	public ResponseEntity<Response> getAllSuvicharURL(@PathVariable int langCode){
		Response allSuvicharURL = this.suService.getAllSuvicharURL(langCode);
		return ResponseEntity.ok(allSuvicharURL);
	}
	
}
