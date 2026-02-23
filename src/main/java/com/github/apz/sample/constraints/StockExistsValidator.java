package com.github.apz.sample.constraints;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.github.apz.sample.repository.ItemRepository;

import lombok.AllArgsConstructor;

@Component @AllArgsConstructor
public class StockExistsValidator implements ConstraintValidator<StockExistsConstraint, String> {
	
	private ItemRepository itemRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Objects.isNull(value)) {
			return true; // @NotNullでチェックするため、nullは有効とする
		}
		
		try {
			Integer.valueOf(value);
		} catch (NumberFormatException e) {
			return false; // 数値でない場合は無効
		}
		return itemRepository.findById(Integer.valueOf(value)).isPresent();
	}

}
