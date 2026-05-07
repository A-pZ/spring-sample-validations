package com.github.apz.sample.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.github.apz.sample.model.ItemRecord;

@Mapper
public interface ItemMapper {
	List<ItemRecord> findStocks();
	
	Optional<ItemRecord> findById(Integer itemId);
}
