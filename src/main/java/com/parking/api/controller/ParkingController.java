package com.parking.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.api.dto.ParkingResponseDto;
import com.parking.api.service.ParkingService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ParkingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingController.class);

	@Autowired
	ParkingService parkingService;
    /**
     * 
     * @return ResponseEntity<List<ParkingResponseDto>>
     */
    @GetMapping("/showSlots")
	public ResponseEntity<List<ParkingResponseDto>> getAllSlot() {
		LOGGER.info("inside getAllSlot method of ParkingController class");
		List<ParkingResponseDto> response = parkingService.getAllSlot();
		return new ResponseEntity<List<ParkingResponseDto>>(response, HttpStatus.OK);
	}
    
    @GetMapping("/showDailySlot/{dailyDate}")
    public ResponseEntity<List<ParkingResponseDto>> getDailyAllSlot(@PathVariable String  dailyDate)
    {
    	LocalDate localDate = LocalDate.parse(dailyDate);
    	List<ParkingResponseDto> response = parkingService.getDailySlot(localDate);
    	
    	return new ResponseEntity<List<ParkingResponseDto>>(response, HttpStatus.OK);
    }
}
