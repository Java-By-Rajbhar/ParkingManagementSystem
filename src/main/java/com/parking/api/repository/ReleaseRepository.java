package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.Release;

public interface ReleaseRepository extends JpaRepository<Release, Integer>{

}
