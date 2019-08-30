package com.parking.api.service;

import com.parking.api.dto.BookedSlotResponseDto;
import com.parking.api.dto.RegistrationRequestDto;
import com.parking.api.dto.RegistrationResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface EmployeeRegistrationService {
	
	public RegistrationResponseDto registration(RegistrationRequestDto registrationRequestDto);
	
	public BookedSlotResponseDto showBookedSlot(int id);

}
