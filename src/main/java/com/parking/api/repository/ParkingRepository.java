package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.Parking;

/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

}
