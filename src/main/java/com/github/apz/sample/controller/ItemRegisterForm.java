package com.github.apz.sample.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemRegisterForm {
	@NotBlank(message = "商品名は必須です")
	@Size(min=1, max = 50, message = "商品名は100文字以内でなければなりません")
	private String name;
	@NotNull(message = "価格は必須です")
	@Min(value = 0, message = "価格は0以上でなければなりません")
	private Integer price;
}
