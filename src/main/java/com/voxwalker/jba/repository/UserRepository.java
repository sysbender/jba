package com.voxwalker.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voxwalker.jba.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
