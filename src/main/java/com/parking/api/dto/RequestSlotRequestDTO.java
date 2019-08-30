package com.parking.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestSlotRequestDTO {
	private int employeeId;
	private LocalDate requestForDate;

}
