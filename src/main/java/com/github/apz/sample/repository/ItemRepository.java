package com.github.apz.sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.apz.sample.mapper.ItemMapper;
import com.github.apz.sample.model.ItemRecord;
import com.github.apz.sample.model.ItemStock;

import lombok.AllArgsConstructor;

@Repository @AllArgsConstructor
public class ItemRepository {
	private ItemMapper itemMapper;

	public List<ItemStock> findStocks() {
		return itemMapper.findStocks().stream().map(this::toItemStock).toList();
	}

	public Optional<ItemStock> findById(Integer itemId) {
		return itemMapper.findById(itemId).map(this::toItemStock);
	}
	
	ItemStock toItemStock(ItemRecord itemRecord) {
		return new ItemStock(itemRecord.itemId(), itemRecord.itemName(), itemRecord.stock());
	}
}
