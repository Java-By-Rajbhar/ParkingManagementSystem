package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.DailyParking;

@Repository
public interface DailyParkingRepository extends JpaRepository<DailyParking, Integer> {

}
