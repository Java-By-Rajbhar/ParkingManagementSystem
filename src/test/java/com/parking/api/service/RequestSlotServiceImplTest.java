package com.parking.api.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.api.dto.BookSlotRequestDto;
import com.parking.api.dto.RequestSlotRequestDTO;
import com.parking.api.dto.RequestSlotResponseDTO;
import com.parking.api.entity.ParkingRequest;
import com.parking.api.repository.ParkingRequestRepository;

@RunWith(MockitoJUnitRunner.class)
public class RequestSlotServiceImplTest {

	@InjectMocks
	RequestSlotServiceImpl requestSlotServiceImpl;
	@Mock
	ParkingRequestRepository parkingRequestRepository;

	@Test
	public void requestSlotTest() {

		RequestSlotResponseDTO requestSlotResponseDTO = new RequestSlotResponseDTO();
		requestSlotResponseDTO.setMessage("Request sent Successfully");
		requestSlotResponseDTO.setStatus("success");
		requestSlotResponseDTO.setStatusCode(201);
		
		RequestSlotRequestDTO requestSlotRequestDTO = new RequestSlotRequestDTO();
		requestSlotRequestDTO.setEmployeeId(1);
		requestSlotRequestDTO.setRequestForDate(LocalDate.now());
		
		List<ParkingRequest> parkingList = new ArrayList<>();
		ParkingRequest parkingRequest = new ParkingRequest();
		parkingRequest.setEmployeeId(1);
		parkingList.add(parkingRequest);
		
		Mockito.when(parkingRequestRepository.findByEmployeeId(Mockito.anyInt())).thenReturn(parkingList);
		
		RequestSlotResponseDTO actual = requestSlotServiceImpl.requestSlot(requestSlotRequestDTO);
		assertEquals(201, actual.getStatusCode());
		assertEquals("Already Requested for a Slot", actual.getMessage());
		assertEquals("Failed", actual.getStatus());

	}
	
	@Test
	public void bookSlotTest() {

		RequestSlotResponseDTO requestSlotResponseDTO = new RequestSlotResponseDTO();
		requestSlotResponseDTO.setMessage("Request sent Successfully");
		requestSlotResponseDTO.setStatus("success");
		requestSlotResponseDTO.setStatusCode(201);
		
		BookSlotRequestDto bookSlotRequestDto = new BookSlotRequestDto();
		bookSlotRequestDto.setEmployeeId(1);
		bookSlotRequestDto.setRequestForDate(LocalDate.now());
		bookSlotRequestDto.setAllotedParkingSlotId(1);
		
		List<ParkingRequest> parkingList = new ArrayList<>();
		ParkingRequest parkingRequest = new ParkingRequest();
		parkingRequest.setEmployeeId(1);
		parkingList.add(parkingRequest);
		
		Mockito.when(parkingRequestRepository.findByEmployeeId(Mockito.anyInt())).thenReturn(parkingList);
		
		RequestSlotResponseDTO actual = requestSlotServiceImpl.bookSlot(bookSlotRequestDto);
		assertEquals(201, actual.getStatusCode());
		assertEquals("Already Requested for a Slot", actual.getMessage());
		assertEquals("Failed", actual.getStatus());

	}

}
