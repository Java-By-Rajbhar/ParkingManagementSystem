package com.parking.api.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.api.dto.ParkingResponseDto;
import com.parking.api.entity.Parking;
import com.parking.api.repository.ParkingRepository;

@RunWith(MockitoJUnitRunner.class)
public class ParkingServiceImplTest {
	
	@InjectMocks
	ParkingServiceImpl parkingServiceImpl;
	@Mock
	ParkingRepository parkingRepository;
	
	@Test
	public void getAllSlotTest()
	{
		List<Parking> listPark = new ArrayList<>();
		Parking park =  new Parking();
		park.setParkingId(100);
		park.setParkingLocation("Electronic city");
		listPark.add(park);
		Mockito.when(parkingRepository.findAll()).thenReturn(listPark);
		
		List<ParkingResponseDto> response = parkingServiceImpl.getAllSlot();
		
		assertEquals(100, response.get(0).getParkingId());
	}

}
