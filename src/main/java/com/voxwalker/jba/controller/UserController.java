package com.voxwalker.jba.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voxwalker.jba.entity.Blog;
import com.voxwalker.jba.entity.User;
import com.voxwalker.jba.service.BlogService;
import com.voxwalker.jba.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	// user is commandName, used to bind form to an object
	// path is form => attribute in object
	@ModelAttribute("user")   
	public User ConstructUser(){
		return new User();
	}
	
	// blog
	@ModelAttribute("blog")   
	public Blog ConstructBlog(){
		return new Blog();
	}	
	
	
	@RequestMapping("/users")
	public String users(Model model){
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		System.out.println("users========= controller, find users:  " + users.size());
		
		return "users";
	}

	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister(){
		System.out.println("--------------- get : register");
		return "user-register";
	}
	
	@RequestMapping( value="/register", method=RequestMethod.POST )
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return"redirect:/register.html?success=true";
	}
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "user-detail";
	}
	
	
	
	@RequestMapping( value="/account", method=RequestMethod.POST )
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
		
	}
	
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		blogService.delete(id);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/users/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users.html";
	}
}
