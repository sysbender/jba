package com.voxwalker.jba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voxwalker.jba.entity.User;
import com.voxwalker.jba.service.BlogService;
import com.voxwalker.jba.service.UserService;

@RequestMapping("/register")
@Controller
public class RegisterController {

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
	
	
	

	@RequestMapping
	public String showRegister() {
		System.out.println("--------------- get : register");
		return "user-register";
	}

	@RequestMapping( method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
}
