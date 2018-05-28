package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Item;
import com.example.demo.service.ItemService;
import com.example.demo.web.dto.ItemDTO;

@Component
public class ItemDTOToItem implements Converter<ItemDTO, Item> {

	@Autowired
	ItemService itemService;

	@Override
	public Item convert(ItemDTO dto) {

		Item item = new Item();

		if (dto.getId() != null) {
			item = itemService.findOne(dto.getId());

			if (item == null) {
				throw new IllegalStateException("Tried to modify a non-existant item");
			}
		}

		item.setId(dto.getId());
		item.setItemName(dto.getName());
		item.setDescription(dto.getDescription());
		item.setBarcode(dto.getBarcode());
		item.setOrderNumber(dto.getOrderNumber());
		item.setValue(dto.getValue());
		item.setCategory(dto.getCategory());

		return item;
	}

	public List<Item> convert(List<ItemDTO> dtos) {

		List<Item> items = new ArrayList<>();

		for (ItemDTO dto : dtos) {
			items.add(convert(dto));
		}

		return items;

	}

}
