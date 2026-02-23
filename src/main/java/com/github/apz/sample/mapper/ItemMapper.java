package com.github.apz.sample.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.github.apz.sample.model.ItemStock;

@Mapper
public interface ItemMapper {
	List<ItemStock> findStocks();
	
	Optional<ItemStock> findById(Integer itemId);
}
