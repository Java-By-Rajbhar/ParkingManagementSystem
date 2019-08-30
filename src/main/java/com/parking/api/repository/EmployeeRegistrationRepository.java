package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.EmployeeRegistration;
/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistration, Integer> {

}
