package com.github.apz.sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.apz.sample.mapper.ItemMapper;
import com.github.apz.sample.model.ItemStock;

import lombok.AllArgsConstructor;

@Repository @AllArgsConstructor
public class ItemRepository {
	private ItemMapper itemMapper;

	public List<ItemStock> findStocks() {
		return itemMapper.findStocks();
	}

	public Optional<ItemStock> findById(Integer itemId) {
		return itemMapper.findById(itemId);
	}	
}
