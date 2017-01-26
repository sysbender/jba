package com.voxwalker.jba.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	

	// blog
	@ModelAttribute("blog")   
	public Blog ConstructBlog(){
		return new Blog();
	}	
	


	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		System.out.println("---------------in account : show user detail");
		String name = principal.getName();
		User user = userService.findOneWithBlogs(name);
		model.addAttribute("user", user);
		System.out.println("---------------in account : show user detail - " + user.getName() );
		return "account";
	}
	
	
	
	@RequestMapping( value="/account", method=RequestMethod.POST )
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, Principal principal, BindingResult result){
		if(result.hasErrors()){
			System.out.println("--------add blog has errors");
			return account(model, principal);
		}
		System.out.println("--------add blog no errors");
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
		
	}
	
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}

}
