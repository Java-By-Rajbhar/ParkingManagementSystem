package com.parking.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class RegistrationRequestDto {
	
	private int roleId;
	private String employeeName;
	private int experience;
	private int totalExperience;
	private String email;
	private String password;

}
