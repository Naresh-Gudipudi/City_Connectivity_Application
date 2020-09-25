package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.datapopulate.PopulateEntries;

@RestController
@ResponseBody
public class FinalResult {

	@GetMapping("/connected")
	public String verifyConnectivity(@RequestParam String origin,@RequestParam String destination) {
		
		if ((origin == null) || (origin == "")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid origin city provided in the request");
		}
		
		if ((destination == null) || (destination == "")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid destination city provided in the request");
		}
		
		PopulateEntries popEntries = new PopulateEntries();
		
		if (!popEntries.isCityValid(origin)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid origin city provided in the request. Only supported cities for origin are: " + popEntries.cityList);
		}
		
		if (!popEntries.isCityValid(destination)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid destination city provided in the request. Only supported cities for destination are: " + popEntries.cityList);
		}
		
		popEntries.setSourceCity(origin);
		popEntries.setDestinationCity(destination);
		return popEntries.retrieveFinalOutput();
	}
}
