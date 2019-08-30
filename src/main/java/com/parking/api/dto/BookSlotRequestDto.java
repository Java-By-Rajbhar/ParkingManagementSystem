package com.parking.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookSlotRequestDto {
	private int employeeId;
	private int allotedParkingSlotId;
	private LocalDate requestForDate;

}
