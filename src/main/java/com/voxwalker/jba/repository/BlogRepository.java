package com.voxwalker.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voxwalker.jba.entity.Blog;
import com.voxwalker.jba.entity.User;

public interface BlogRepository  extends JpaRepository<Blog, Integer>{
	/*
	 *  User is an attribute in blog entity , 
	 *  spring will generate the implementation of this method.
	 */
	List<Blog> findByUser(User user);
}
