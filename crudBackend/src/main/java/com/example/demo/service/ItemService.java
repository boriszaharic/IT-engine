package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Item;

public interface ItemService {

	Item findOne(Long id);

	void save(Item item);

	void remove(Long id);

	
}
