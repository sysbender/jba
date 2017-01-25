package com.voxwalker.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voxwalker.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);
	

}
