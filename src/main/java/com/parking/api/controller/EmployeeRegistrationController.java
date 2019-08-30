package com.parking.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class EmployeeRegistrationController {
	
	@PostMapping("/register")
	public ResponseEntity<RegistrationResponseDto> register(@RequestBody RegistrationRequestDto registrationRequestDto)
	{
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
