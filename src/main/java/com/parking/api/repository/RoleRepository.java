package com.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.api.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Role findByRoleName(String name);

}
