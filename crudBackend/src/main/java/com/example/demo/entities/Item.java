package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private long id;
	private String itemName;
	private String orderNumber;
	private String category;
	private String value;
	private String description;
	private int barcode;
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", orderNumber=" + orderNumber + ", category=" + category
				+ ", value=" + value + ", description=" + description + ", barcode=" + barcode + "]";
	}
	public Item() {
	}
	
	public Item(String itemName, String orderNumber, String category, String value, String description, int barcode) {
		this.itemName = itemName;
		this.orderNumber = orderNumber;
		this.category = category;
		this.value = value;
		this.description = description;
		this.barcode = barcode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
}
