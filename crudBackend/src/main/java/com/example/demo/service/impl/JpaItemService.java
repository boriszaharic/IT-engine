package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Item;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.service.ItemService;

@Service
@Transactional
public class JpaItemService implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item findOne(Long id) {
		if (itemRepository.existsById(id))
			return itemRepository.getOne(id);
		return null;
	}

	@Override
	public void save(Item item) {

		itemRepository.save(item);

	}

	@Override
	public void remove(Long id) {

		itemRepository.deleteById(id);

	}

}