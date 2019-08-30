package com.parking.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.api.dto.BookedSlotResponseDto;
import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;
import com.parking.api.service.EmployeeRegistrationService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class EmployeeRegistrationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	@Autowired
	private EmployeeRegistrationService employeeRegistrationService;
	
	@PostMapping("/register")
	public ResponseEntity<RegistrationResponseDto> register(@RequestBody RegistrationRequestDto registrationRequestDto)
	{
		LOGGER.info("EmployeeRegistrationController employeeRegistrationService");
		
		return new ResponseEntity<>(employeeRegistrationService.registration(registrationRequestDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/slotBook/{employeeId}")
	public ResponseEntity<BookedSlotResponseDto> showBookedSlot(@PathVariable int employeeId)
	{
		
		
		return new ResponseEntity<>(employeeRegistrationService.showBookedSlot(employeeId),HttpStatus.CREATED);
	}

}
