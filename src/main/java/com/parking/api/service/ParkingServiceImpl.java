package com.parking.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.api.dto.ParkingResponseDto;
import com.parking.api.entity.DailyParking;
import com.parking.api.entity.Parking;
import com.parking.api.repository.DailyParkingRepository;
import com.parking.api.repository.ParkingRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class ParkingServiceImpl implements ParkingService{
private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServiceImpl.class);
	@Autowired
	ParkingRepository parkingRepository;
	@Autowired
	DailyParkingRepository dailyParkingRepository;
	
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

	@Override
	public List<ParkingResponseDto> getDailySlot(LocalDate dailyDate) {
		LOGGER.info("Inside getDailySlot method of ParkingServiceImpl class");
		List<ParkingResponseDto> response = new ArrayList<>();
		List<DailyParking> listPark =  dailyParkingRepository.findByDailyDate(dailyDate);
		for (DailyParking dailyParking : listPark) {
			Parking parking  = parkingRepository.findByParkingId(dailyParking.getParkingId());
			ParkingResponseDto responseDto  = new ParkingResponseDto();
			LOGGER.info("data dailyParking.getEmployeeId() ={}",dailyParking.getEmployeeId());
			if(dailyParking.getEmployeeId()==null)
			{
				responseDto.setIsReserved("true");
			}
			else
			{
				responseDto.setIsReserved("false");
			}
			responseDto.setParkingId(parking.getParkingId());
			responseDto.setTowerName(parking.getTowerName());
			responseDto.setParkingLocation(parking.getParkingLocation());
			
			response.add(responseDto);
		}
		return response;
	}

}
