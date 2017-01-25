package com.voxwalker.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voxwalker.jba.entity.Blog;
import com.voxwalker.jba.entity.User;
import com.voxwalker.jba.repository.BlogRepository;
import com.voxwalker.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	

	@Autowired
	private UserRepository userRepository;
	
	
	public void save(Blog blog, String name) {
		 
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}

}
