package com.github.apz.sample.controller;

import jakarta.validation.constraints.NotNull;

import com.github.apz.sample.constraints.StockExistsConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemForm {
	@NotNull(message = "商品IDは必須です")
	@StockExistsConstraint
	private String itemId;
}
