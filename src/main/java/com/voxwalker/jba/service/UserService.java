package com.voxwalker.jba.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voxwalker.jba.entity.Blog;
import com.voxwalker.jba.entity.Item;
import com.voxwalker.jba.entity.User;
import com.voxwalker.jba.repository.BlogRepository;
import com.voxwalker.jba.repository.ItemRepository;
import com.voxwalker.jba.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {		
		return userRepository.findOne(id);
	}

	@Transactional 
	public User findOneWithBlogs(int id) {
		 User user= findOne(id);
		 List<Blog> blogs = blogRepository.findByUser(user);
		 for( Blog blog : blogs){
			 List<Item> items =  itemRepository.findByBlog(blog);
			 blog.setItems(items);
		 }
		 user.setBlogs(blogs);
		return user;
	}
}
