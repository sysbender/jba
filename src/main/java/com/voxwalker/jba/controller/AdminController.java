package com.voxwalker.jba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voxwalker.jba.entity.User;
import com.voxwalker.jba.service.UserService;

@RequestMapping("/users")
@Controller
public class AdminController {

	
	@Autowired
	private UserService userService;

	
	@RequestMapping
	public String users(Model model){
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		System.out.println("users========= controller, find users:  " + users.size());
		
		return "users";
	}

	
	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}
	
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users.html";
	}
	
	
}
