package com.parking.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.api.entity.Assignation;
import com.parking.api.entity.DailyParking;
import com.parking.api.entity.Parking;
import com.parking.api.entity.ParkingRequest;
import com.parking.api.entity.ReleaseSlot;
import com.parking.api.repository.AssignationRepository;
import com.parking.api.repository.DailyParkingRepository;
import com.parking.api.repository.ParkingRepository;
import com.parking.api.repository.ParkingRequestRepository;
import com.parking.api.repository.ReleaseRepository;

@Service
public class DailyParkingServiceImpl implements DailyParkingService {

	@Autowired
	private ParkingRepository parkingRepository;
	
	@Autowired
	private AssignationRepository assignationRepository;
	
	@Autowired
	private DailyParkingRepository dailyParkingRepository;
	
	@Autowired
	private ParkingRequestRepository parkingRequestRepository;
	
	@Autowired
	private ReleaseRepository releaseRepository;
	
	@Override
	public void dailyParking() {
		
		List<Parking> parkingList = parkingRepository.findAll();
		List<Assignation> assignatioList = assignationRepository.findAll();
		List<ParkingRequest> parkingRequestList = parkingRequestRepository.findByRequestForDate(LocalDate.now());
		List<ReleaseSlot> releaseSlots = releaseRepository.findAllByBetweenDate();
		
		Map<Integer, Integer> assignMap = new HashMap<Integer, Integer>();

		for(Assignation assignation : assignatioList) {
			assignMap.put(assignation.getParkingId(), assignation.getEmployeeId());
		}
			
//		assignatioList.stream().collect(Collectors.toMap(x -> x. , valueMapper))
		
		List<DailyParking> dailyParkings = new ArrayList<DailyParking>();
		
		for(Parking parking : parkingList ) {
			DailyParking dailyParking = new DailyParking();
			dailyParking.setDailyDate(LocalDate.now());
			dailyParking.setParkingId(parking.getParkingId());
			dailyParking.setEmployeeId(assignMap.get(parking.getParkingId()));
			dailyParkings.add(dailyParking);
		}
		
//		if(releaseSlots!= null && !releaseSlots.isEmpty() && parkingRequestList!= null && !parkingRequestList.isEmpty()) {
//			if(parkingRequestList.size() > releaseSlots.size()) {
//				
//			}
//		}
		dailyParkingRepository.saveAll(dailyParkings);
	}
}
