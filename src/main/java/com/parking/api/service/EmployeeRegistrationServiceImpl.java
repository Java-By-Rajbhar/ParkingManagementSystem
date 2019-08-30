package com.parking.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;
import com.parking.api.entity.EmployeeRegistration;
import com.parking.api.exception.EmailIdInvalidException;
import com.parking.api.repository.EmployeeRegistrationRepository;

public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	@Autowired
	private EmployeeRegistrationRepository employeeRegistrationRepository;
	
	
	@Override
	public RegistrationResponseDto registration(RegistrationRequestDto registrationRequestDto) {

		EmployeeRegistration employeeRegistration=new EmployeeRegistration();
		
		RegistrationResponseDto registrationResponseDto=new RegistrationResponseDto();
		if(isValidEmailAddress(registrationRequestDto.getEmail()))
		 {
			employeeRegistration.setEmail(registrationRequestDto.getEmail());
			employeeRegistration.setEmployeeName(registrationRequestDto.getEmployeeName());
			
			if(registrationRequestDto.getExperience()>=5 && registrationRequestDto.getTotalExperience()>=15)
			{
				
			}
			
		 
			
			registrationResponseDto.setMessage("Parking Slot Alloted");
			registrationResponseDto.setStatusCode(201);
		 }
		else
		{
			throw new EmailIdInvalidException("email Id is invalid");
		}
		
		return null;
	}

	
	
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
}
