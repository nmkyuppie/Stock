package com.mani.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StockController {
	
	/**
	 * @param bean
	 * @return
	 */
	@GetMapping
	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		System.out.println("Loginnnnnnnn");
		return new ModelAndView("login");
	}
}
