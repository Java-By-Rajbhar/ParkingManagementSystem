package com.parking.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.api.entity.ReleaseSlot;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseSlot, Integer>{

	@Query(value ="select * from release_slot where curdate() between from_date and to_date", nativeQuery = true)
	List<ReleaseSlot> findAllByBetweenDate();
}
