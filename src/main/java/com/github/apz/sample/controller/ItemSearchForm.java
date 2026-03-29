package com.github.apz.sample.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.github.apz.sample.constraints.DynamicValidator;
import com.github.apz.sample.constraints.StaticValidators;
import com.github.apz.sample.constraints.StockExistsConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemSearchForm {
	@NotNull(message = "商品IDは必須です", groups = StaticValidators.class)
	@NotBlank(message = "商品IDは空文字であってはいけません", groups = StaticValidators.class)
	@StockExistsConstraint(groups = DynamicValidator.class)
	private String itemId;
}
