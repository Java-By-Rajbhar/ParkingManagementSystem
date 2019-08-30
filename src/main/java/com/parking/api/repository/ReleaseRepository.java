package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.ReleaseSlot;


@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseSlot, Integer>{

}
