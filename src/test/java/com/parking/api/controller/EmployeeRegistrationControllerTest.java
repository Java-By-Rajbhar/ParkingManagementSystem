package com.parking.api.controller;

import static org.junit.Assert.assertEquals;

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
import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;
import com.parking.api.service.EmployeeRegistrationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRegistrationControllerTest {
	
	@InjectMocks
	EmployeeRegistrationController registrationController;

	private MockMvc mockMvc;
	
	@Mock
	EmployeeRegistrationServiceImpl employeeRegistrationServiceImpl;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
	}
	
	@Test
	public void registerTest() throws JsonProcessingException, Exception
	{
		RegistrationRequestDto requestdto = new RegistrationRequestDto();
		requestdto.setEmployeeName("raja");
		requestdto.setExperience(5);
		requestdto.setTotalExperience(15);
		RegistrationResponseDto dto  = new RegistrationResponseDto();
		dto.setMessage("succcess");
		dto.setStatusCode(200);
		Mockito.when(employeeRegistrationServiceImpl.registration(Mockito.any())).thenReturn(dto);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(requestdto))).andReturn();
		
		ResponseEntity<RegistrationResponseDto> response  = registrationController.register(requestdto);
		
		assertEquals(201, response.getStatusCodeValue());
	}

}
