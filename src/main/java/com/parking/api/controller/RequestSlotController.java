package com.parking.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.api.dto.BookSlotRequestDto;
import com.parking.api.dto.RequestSlotRequestDTO;
import com.parking.api.dto.RequestSlotResponseDTO;
import com.parking.api.service.RequestSlotService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })

public class RequestSlotController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	@Autowired
	RequestSlotService requestService;

	@PostMapping("/requestSlot")
	public ResponseEntity<RequestSlotResponseDTO> requestSlot(@RequestBody RequestSlotRequestDTO requestSlotRequestDTO) {
		LOGGER.info("inside request Slot");
		RequestSlotResponseDTO requestSlotResponseDTO = requestService.requestSlot(requestSlotRequestDTO);

		return new ResponseEntity<>(requestSlotResponseDTO, HttpStatus.OK);
	}

	@PostMapping("/bookSlot")
	public ResponseEntity<RequestSlotResponseDTO> bookSlot(@RequestBody BookSlotRequestDto bookSlotRequestDto) {
		RequestSlotResponseDTO requestSlotResponseDTO = requestService.bookSlot(bookSlotRequestDto);

		return new ResponseEntity<>(requestSlotResponseDTO, HttpStatus.OK);
	}

}
