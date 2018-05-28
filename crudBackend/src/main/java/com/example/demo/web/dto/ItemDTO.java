package com.example.demo.web.dto;

import java.util.ArrayList;
import java.util.List;


public class ItemDTO {

	private Long id;

	private String name;

	private Integer orderNumber;

	private String value;

	private String description;

	private Integer barcode;

	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBarcode() {
		return barcode;
	}

	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	public List<String> toStringAll() {
		
		List<String> raw = new ArrayList<>();
		
		raw.add(this.getId().toString());
		raw.add(this.getName());
		raw.add(this.getOrderNumber().toString());
		raw.add(this.getValue().toString());
		raw.add(this.getDescription());
		raw.add(this.getBarcode().toString());
		raw.add(this.getCategory());
		
		return raw;
	}

}