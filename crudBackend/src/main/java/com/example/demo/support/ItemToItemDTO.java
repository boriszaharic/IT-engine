package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Item;
import com.example.demo.web.dto.ItemDTO;

@Component
public class ItemToItemDTO implements Converter<Item, ItemDTO> {

	@Override
	public ItemDTO convert(Item item) {

		ItemDTO dto = new ItemDTO();

		dto.setId(item.getId());
		dto.setBarcode(item.getBarcode());
		dto.setDescription(item.getDescription());
		dto.setName(item.getItemName());
		dto.setOrderNumber(item.getOrderNumber());
		dto.setValue(item.getValue());

		return dto;
	}

	public List<ItemDTO> convert(List<Item> items) {

		List<ItemDTO> dtos = new ArrayList<>();

		for (Item item : items) {
			dtos.add(convert(item));
		}

		return dtos;

	}

}
