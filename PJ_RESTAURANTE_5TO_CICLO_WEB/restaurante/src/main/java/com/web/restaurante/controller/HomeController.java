package com.web.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/index")
	private String index() {
		
		return "/index";
	}
	
	@GetMapping("/homeProducto")
	private String HomeProductos() {
		return "/homeProducto";
	}
	
}
