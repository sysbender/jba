package com.voxwalker.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voxwalker.jba.entity.Blog;
import com.voxwalker.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	public List<Item> findByBlog(Blog blog);

}
