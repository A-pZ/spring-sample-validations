package com.github.apz.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ItemStock {
	private Integer itemId;
	private String itemName;
	private Integer stock;
}
