package com.github.apz.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.apz.sample.model.ItemStock;
import com.github.apz.sample.repository.ItemRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor	
@Slf4j
public class ItemService {
	private ItemRepository itemRepository;
	
	public List<ItemStock> findStocks() {
		return itemRepository.findStocks();
	}
	
	public Optional<ItemStock> findById(Integer itemId) {
		return itemRepository.findById(itemId);
	}
}
