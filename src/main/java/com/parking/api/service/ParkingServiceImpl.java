package com.parking.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.api.dto.ParkingResponseDto;
import com.parking.api.entity.Parking;
import com.parking.api.repository.ParkingRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class ParkingServiceImpl implements ParkingService{

	@Autowired
	ParkingRepository parkingRepository;
	/**
	 * 
	 */
	@Override
	public List<ParkingResponseDto> getAllSlot() {
		
		List<ParkingResponseDto> response = new ArrayList<>();
		
		List<Parking> listParking = parkingRepository.findAll();
		
		for (Parking parking : listParking) {
			ParkingResponseDto responseDto  = new ParkingResponseDto();
			responseDto.setParkingId(parking.getParkingId());
			responseDto.setTowerName(parking.getTowerName());
			responseDto.setIsReserved(parking.getIsReserved());
			responseDto.setParkingLocation(parking.getParkingLocation());
			
			response.add(responseDto);
			
		}
		
		return response;
	}

}
