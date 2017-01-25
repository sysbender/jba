package com.voxwalker.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voxwalker.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
