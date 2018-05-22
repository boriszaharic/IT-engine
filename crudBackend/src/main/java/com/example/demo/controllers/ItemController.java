package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Item;
import com.example.demo.repositories.ItemRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/items")
	public List<Item> getItems(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/item/{id}")
	public Item getItem(@PathVariable Long id){
		return itemRepository.findOne(id);
	}
	
	@DeleteMapping("/item/{id}")
	public boolean deleteItem(@PathVariable Long id){
		itemRepository.delete(id);
		return true;
	}
	
	@PostMapping("/item")
	public Item createItem(@RequestBody Item item){
		return itemRepository.save(item);
	}
	
	@PutMapping("/item")
	public Item updateItem(@RequestBody Item item){
		return itemRepository.save(item);
	}
}
