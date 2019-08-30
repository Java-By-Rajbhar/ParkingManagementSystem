package com.parking.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.api.dto.ReleaseSlotRequestDto;
import com.parking.api.dto.ReleaseSlotResponeDto;
import com.parking.api.service.ReleaseSlotService;

/**
 * 
 * @author Shashank
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ReleaseController {
	
	@Autowired
	private ReleaseSlotService releaseSlotService;
	
	@PostMapping("/releaseSlot")
	public ResponseEntity<ReleaseSlotResponeDto> releaseSlot(@RequestBody ReleaseSlotRequestDto releaseSlotRequestDto)
	{
		
		return new ResponseEntity<>(releaseSlotService.releaseSlot(releaseSlotRequestDto),HttpStatus.CREATED);
	}

}
