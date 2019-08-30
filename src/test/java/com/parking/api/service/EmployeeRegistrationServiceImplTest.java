package com.parking.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;
import com.parking.api.entity.EmployeeRegistration;
import com.parking.api.entity.Parking;
import com.parking.api.entity.Role;
import com.parking.api.exception.UserAlreadyAvailable;
import com.parking.api.repository.AssignationRepository;
import com.parking.api.repository.EmployeeRegistrationRepository;
import com.parking.api.repository.ParkingRepository;
import com.parking.api.repository.RoleRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRegistrationServiceImplTest {
	
	
	
	@Mock
	private EmployeeRegistrationRepository employeeRegistrationRepository;

	@Mock
	private RoleRepository roleRepository;

	@Mock
	private AssignationRepository assignationRepository;

	@Mock
	private ParkingRepository parkingRepository;
	
	@InjectMocks
	EmployeeRegistrationServiceImpl registrationServiceImpl;
	
	@Test(expected = UserAlreadyAvailable.class)
	public void registrationTest()
	{
		EmployeeRegistration employeeRegistration = new EmployeeRegistration();
		employeeRegistration.setEmail("shashankkum@gmail.com");
		employeeRegistration.setEmployeeId(1);
		employeeRegistration.setEmployeeName("Shashank kumar");
		employeeRegistration.setExperience(5);
		employeeRegistration.setPassword("ok");
		employeeRegistration.setRoleId(1);
		employeeRegistration.setTotalExperience(15);
		
		Role role=new Role();
		role.setRoleId(1);
		role.setRoleName("VIP");
		
		Parking parking =new Parking();
		parking.setIsReserved("true");
		parking.setParkingId(1);
		parking.setParkingLocation("p1");
		parking.setTowerName("t1");
		
		RegistrationRequestDto registrationRequestDto=new RegistrationRequestDto();
		registrationRequestDto.setEmail("shashankkuma@gmail.com");
		registrationRequestDto.setEmployeeName("shashank kumar");
		registrationRequestDto.setExperience(5);
		registrationRequestDto.setPassword("ok");
		registrationRequestDto.setTotalExperience(15);
		
		
		List<Parking> listParking=new ArrayList<>();
		listParking.add(parking);
		
		when(employeeRegistrationRepository.findByEmail(Mockito.anyString())).thenReturn(employeeRegistration);
		
		
		
		RegistrationResponseDto registrationResponseDto=registrationServiceImpl.registration(registrationRequestDto);
		
		assertEquals(201, registrationResponseDto.getStatusCode());
		
	}

}
