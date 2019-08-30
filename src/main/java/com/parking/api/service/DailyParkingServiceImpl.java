package com.parking.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parking.api.entity.Assignation;
import com.parking.api.entity.Parking;
import com.parking.api.repository.AssignationRepository;
import com.parking.api.repository.DailyParkingRepository;
import com.parking.api.repository.ParkingRepository;

public class DailyParkingServiceImpl implements DailyParkingService {

	@Autowired
	private ParkingRepository parkingRepository;
	
	@Autowired
	private AssignationRepository assignationRepository;
	
	@Autowired
	private DailyParkingRepository dailyParkingRepository;
	
	@Override
	public void dailyParking(LocalDate localDate) {
		
		List<Parking> parkingList = parkingRepository.findAll();
		List<Assignation> assignatioList = assignationRepository.findAll();
		
		
	}
}
