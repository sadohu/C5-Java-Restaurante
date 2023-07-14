package com.web.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.restaurante.business.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/listaUsuario")
	private String listaUsuario (Model model) {
		model.addAttribute("listaUsuario",service.listarUsuario());
		return "listaUsuario";
	}
	
	@GetMapping("/actualizaUsuario")
	private String actualizaUsuario(Model model) {
		return "actualizaUsuario";
	}
	
}
