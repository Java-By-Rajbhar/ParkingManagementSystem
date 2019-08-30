package com.parking.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.parking.api.controller.RequestSlotController;
import com.parking.api.dto.BookSlotRequestDto;
import com.parking.api.dto.RequestSlotRequestDTO;
import com.parking.api.dto.RequestSlotResponseDTO;
import com.parking.api.service.RequestSlotService;


@RunWith(SpringJUnit4ClassRunner.class)
public class RequestSlotControllerTest {

	
	@Mock
	RequestSlotService requestService;
	
	@InjectMocks
	RequestSlotController requestSlotController;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(requestSlotController).build();
	}
	
	
	@Test
	public void requestSlotTest() throws Exception {
	
		RequestSlotResponseDTO requestSlotResponseDTO=new RequestSlotResponseDTO();
		requestSlotResponseDTO.setMessage("Request sent Successfully");
		requestSlotResponseDTO.setStatus("success");
		requestSlotResponseDTO.setStatusCode(201);
		RequestSlotRequestDTO requestSlotRequestDTO = new RequestSlotRequestDTO();
		requestSlotRequestDTO.setEmployeeId(1);
		requestSlotRequestDTO.setRequestForDate(LocalDate.now());
	
		when(requestService.requestSlot(Mockito.any())).thenReturn(requestSlotResponseDTO);
		

		mockMvc.perform(MockMvcRequestBuilders.post("/requestSlot").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();

		ResponseEntity<RequestSlotResponseDTO> actual=requestSlotController.requestSlot(requestSlotRequestDTO);
		assertEquals(201, actual.getBody().getStatusCode());
		assertEquals("Request sent Successfully", actual.getBody().getMessage());
		assertEquals("success", actual.getBody().getStatus());
	
	}
	
	
	@Test
	public void bookSlotTest() throws Exception {
	
		RequestSlotResponseDTO requestSlotResponseDTO=new RequestSlotResponseDTO();
		requestSlotResponseDTO.setMessage("Request sent Successfully");
		requestSlotResponseDTO.setStatus("success");
		requestSlotResponseDTO.setStatusCode(201);
		BookSlotRequestDto bookSlotRequestDto = new BookSlotRequestDto();
		bookSlotRequestDto.setEmployeeId(1);
		bookSlotRequestDto.setRequestForDate(LocalDate.now());
		bookSlotRequestDto.setAllotedParkingSlotId(1);
		
	
		when(requestService.bookSlot(Mockito.any())).thenReturn(requestSlotResponseDTO);
		

		mockMvc.perform(MockMvcRequestBuilders.post("/bookSlot").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(""))).andReturn();

		ResponseEntity<RequestSlotResponseDTO> actual=requestSlotController.bookSlot(bookSlotRequestDto);
		assertEquals(201, actual.getBody().getStatusCode());
		assertEquals("Request sent Successfully", actual.getBody().getMessage());
		assertEquals("success", actual.getBody().getStatus());
	
	}
	
	public static String asJsonString(final Object obj) {

		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}