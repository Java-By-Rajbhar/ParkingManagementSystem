package com.parking.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer>{

	
	public List<Parking> findByIsReserved(String status);
	
}
