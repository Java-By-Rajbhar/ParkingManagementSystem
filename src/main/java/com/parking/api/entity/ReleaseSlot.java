package com.parking.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Shashank
 *
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class ReleaseSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int releaseId;
	private int employeeId;
	private LocalDate fromDate;
	private LocalDate toDate;

}

 



