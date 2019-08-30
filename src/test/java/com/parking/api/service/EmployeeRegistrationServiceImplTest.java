package com.parking.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.parking.api.entity.EmployeeRegistration;
import com.parking.api.repository.AssignationRepository;
import com.parking.api.repository.EmployeeRegistrationRepository;
import com.parking.api.repository.ParkingRepository;
import com.parking.api.repository.RoleRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRegistrationServiceImplTest {
	
	EmployeeRegistrationServiceImpl registrationServiceImpl;
	
	@Mock
	private EmployeeRegistrationRepository employeeRegistrationRepository;

	@Mock
	private RoleRepository roleRepository;

	@Mock
	private AssignationRepository assignationRepository;

	@Mock
	private ParkingRepository parkingRepository;
	
	@Test
	public void registrationTest()
	{
		EmployeeRegistration employeeRegistration = new EmployeeRegistration();
		//Mockito.when(methodCall)
	}

}
