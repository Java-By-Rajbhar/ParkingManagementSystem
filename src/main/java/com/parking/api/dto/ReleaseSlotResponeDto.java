package com.parking.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Shashank
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class ReleaseSlotResponeDto {
	
	private String message;
	private int statusCode;
	private String status;

}
