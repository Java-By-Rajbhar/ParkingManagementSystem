package com.parking.api.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parking.api.dto.ParkingResponseDto;
import com.parking.api.service.ParkingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ParkingControllerTest {
	
	@InjectMocks
	ParkingController parkingController;

	private MockMvc mockMvc;
	@Mock
	ParkingServiceImpl parkingServiceImpl;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(parkingController).build();
	}
	
	@Test
	public void getAllSlotTest() throws JsonProcessingException, Exception
	{
		List<ParkingResponseDto> response = new ArrayList<>();
		ParkingResponseDto dto  = new ParkingResponseDto();
		dto.setParkingId(100);
		dto.setIsReserved("true");
		response.add(dto);
		Mockito.when(parkingServiceImpl.getAllSlot()).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/showSlots").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(""))).andReturn();
		ResponseEntity<List<ParkingResponseDto>> response1 = parkingController.getAllSlot();
		
		assertEquals(200, response1.getStatusCodeValue());
	}

}
