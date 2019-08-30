package com.parking.api.service;

import java.time.LocalDate;
import java.util.List;

import com.parking.api.dto.ParkingResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface ParkingService { 
	
	public List<ParkingResponseDto> getAllSlot();
	
	public List<ParkingResponseDto> getDailySlot(LocalDate dailyDate);

}
