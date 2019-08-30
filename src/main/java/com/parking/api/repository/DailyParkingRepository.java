package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.DailyParking;

public interface DailyParkingRepository extends JpaRepository<DailyParking, Integer> {

}
