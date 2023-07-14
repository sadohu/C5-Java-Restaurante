package com.web.restaurante.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/listaUsuario")
	private String listaUsuario (Model model) {
		model.addAttribute("listaUsuario",service.listarUsuario());
		return "/listaUsuario";
	}
	
	@GetMapping("/registraUsuario")
	private String registrarUsuario(@ModelAttribute("usuario") Model model) {
		return "/registraUsuario";
	}
	
	@GetMapping("/actualizaUsuario/{id}")
	private String actualizaUsuario(@PathVariable(value="id") int id, Model model) {
		Usuario usuario = service.buscarUsuario(id);
		model.addAttribute("usuario",usuario);
		return "/actualizaUsuario";
	}
	
	@PostMapping("grabarUsuario")
	private String actualizarUsuario (@ModelAttribute("usuario") Usuario usuario) {
		FileOutputStream imagenStream = new FileOutputStream(usuario.getImagen_usuario());
		service.registrarUsuario(usuario);
		return "redirect:/listaUsuario";
	}
	

	
}
