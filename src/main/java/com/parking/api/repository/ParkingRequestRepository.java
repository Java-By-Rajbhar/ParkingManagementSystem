package com.parking.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.ParkingRequest;

public interface ParkingRequestRepository extends JpaRepository<ParkingRequest, Integer> {

	List<ParkingRequest> findByEmployeeId(int employeeId);

	List<ParkingRequest> findByRequestForDate(LocalDate requestDate);
}
