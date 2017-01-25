package com.voxwalker.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voxwalker.jba.entity.Blog;
import com.voxwalker.jba.entity.Item;
import com.voxwalker.jba.entity.Role;
import com.voxwalker.jba.entity.User;
import com.voxwalker.jba.repository.BlogRepository;
import com.voxwalker.jba.repository.ItemRepository;
import com.voxwalker.jba.repository.RoleRepository;
import com.voxwalker.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	public InitDbService(){
		System.out.println("-----------     construct init db service -------------");
	}
	
	@PostConstruct
	public void init(){
		System.out.println(" *********   post construct for init db service    ********");
		
		
		// add ROLE_USER and ROLE_ADMIN
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEnabled(true);
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		userAdmin.setPassword(bCrypt.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		
		Blog blog1 = new Blog();
		blog1.setName("JavaVids");
		blog1.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blog1.setUser(userAdmin);
		blogRepository.save(blog1);
		
		
			
		Item item1 = new Item();
		item1.setBlog(blog1);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blog1);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		
		itemRepository.save(item2);
		
		Item item;
		for (String title : new String[]{"3", "4","5","6","7","8","9","10","11","12","13","14"}) {
			System.out.println("title=" + title);
			item = new Item();
			item.setBlog(blog1);
			item.setTitle(title);
			itemRepository.save(item);
		}		
		
	}
}
