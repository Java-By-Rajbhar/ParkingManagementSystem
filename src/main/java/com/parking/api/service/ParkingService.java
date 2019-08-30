package com.parking.api.service;

import java.util.List;

import com.parking.api.dto.ParkingResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface ParkingService { 
	
	public List<ParkingResponseDto> getAllSlot();

}
