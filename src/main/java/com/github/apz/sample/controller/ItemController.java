package com.github.apz.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.sample.service.ItemService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/items")
public class ItemController {
	
	@ModelAttribute("itemForm")
	public ItemForm itemForm() {
		return new ItemForm();
	}
	
	private ItemService itemService;
	
	@GetMapping("")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("items/index");
		mav.addObject("stocks", itemService.findStocks());
		return mav;
	}
	
	@GetMapping("/find")
	public ModelAndView findBy(ModelAndView mav, @Validated ItemForm itemForm, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			log.info("validation error: {}", result.getAllErrors().get(0).getDefaultMessage());
			redirectAttributes.addFlashAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
			mav.setViewName("redirect:/items");
			return mav;
		}
		mav.addObject("stocks", itemService.findStocks());
		var stock = itemService.findById(Integer.valueOf(itemForm.getItemId()));
		mav.addObject(stock.orElseThrow(() -> new IllegalStateException("在庫が見つかりませんでした")));
		mav.setViewName("items/index");
		return mav;
	}
}
