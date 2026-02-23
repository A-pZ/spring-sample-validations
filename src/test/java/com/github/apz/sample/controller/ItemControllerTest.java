package com.github.apz.sample.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.github.apz.sample.model.ItemStock;
import com.github.apz.sample.repository.ItemRepository;
import com.github.apz.sample.service.ItemService;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@MockitoBean
	private ItemService itemService;
	
	@MockitoBean
	private ItemRepository itemRepository;
	
	@Autowired
	private MockMvc mockMvc; 
	
	@Test
	void testIndex() throws Exception {
		when(itemService.findStocks())
			.thenReturn(
					List.of(
							new ItemStock(1, "item1", 10),
							new ItemStock(2, "item2", 20)
					)
			);
		
		mockMvc.perform(get("/items"))
			.andExpect(status().isOk())
			.andExpect(view().name("items/index"));
	}
	
	@Test
	void testGetItem() throws Exception {
		// StockExistsValidatorの実行結果がtrueになるよう設定
		when(itemRepository.findById(anyInt()))
				.thenReturn(
						Optional.of(new ItemStock(1, "item1", 10))
				);
		
		when(itemService.findById(anyInt()))
			.thenReturn(
					Optional.of(new ItemStock(1, "item1", 10))
			);
		
		mockMvc.perform(get("/items/find?itemId=1"))
			.andExpect(status().isOk())
			.andExpect(view().name("items/index"));
	}
	
	@Test
	void testGetItemWithValidationError() throws Exception {
		// StockExistsValidatorの実行結果がfalseになるよう設定
		when(itemRepository.findById(anyInt()))
		.thenReturn(
				Optional.empty()
		);
		
		mockMvc.perform(get("/items/find?itemId=1"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/items"))
			.andExpect(flash().attributeExists("error"));
	}
}
