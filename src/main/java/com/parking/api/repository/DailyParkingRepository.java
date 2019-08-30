package com.parking.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.DailyParking;

@Repository
public interface DailyParkingRepository extends JpaRepository<DailyParking, Integer> {
	
	public List<DailyParking> findByDailyDate(LocalDate dailyDate);

}
