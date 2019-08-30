package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.ReleaseSlot;

public interface ReleaseRepository extends JpaRepository<ReleaseSlot, Integer>{

}
