package com.parking.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking,Integer>{

	
	public List<Parking> findByIsReserved(String status);
	
}
