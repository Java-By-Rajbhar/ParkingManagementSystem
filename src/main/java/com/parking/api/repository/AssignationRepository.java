package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.Assignation;

public interface AssignationRepository extends JpaRepository<Assignation, Integer>{
	
	public Assignation findByEmployeeId(int id);

}
