package com.parking.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.api.dto.LoginDto;
import com.parking.api.dto.LoginResponseDto;
import com.parking.api.entity.EmployeeRegistration;
import com.parking.api.entity.Role;
import com.parking.api.repository.EmployeeRegistrationRepository;
import com.parking.api.repository.RoleRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@Mock
	private EmployeeRegistrationRepository registrationRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	LoginResponseDto loginResponseDto = new LoginResponseDto();
	Role role = new Role();
	LoginDto loginDto = new LoginDto();
	EmployeeRegistration employee = new EmployeeRegistration();
	
	@Before
	public void setUp() {
		loginDto.setEmailId("laxman@hcl.com");
		loginDto.setPassword("hello");
		
		employee.setEmail("laxman@hcl.com");
		employee.setEmployeeId(101);
		employee.setPassword("hello");
		
		role.setRoleId(101);
		role.setRoleName("VIP");

		loginResponseDto.setEmployeeId(101);
		loginResponseDto.setRoleName("VIP");
	}
	@Test
	public void testLogin() {
		
		Mockito.when(registrationRepository.findByEmail(Mockito.anyString())).thenReturn(employee);
		Mockito.when(roleRepository.findByRoleId(Mockito.anyInt())).thenReturn(role);
		
		LoginResponseDto actualLoginResponseDto = loginServiceImpl.userLogin(loginDto);
		
		assertEquals("VIP", actualLoginResponseDto.getRoleName());
	}
}
