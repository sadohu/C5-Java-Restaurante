package com.web.restaurante.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.restaurante.business.Direntrega_UsuarioService;
import com.web.restaurante.business.DistritoService;
import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.Direntrega_Usuario;
import com.web.restaurante.model.Distrito;
import com.web.restaurante.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class Direntrega_UsuarioController {
	
	@Autowired
	private Direntrega_UsuarioService direntrega_usuarioService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private DistritoService distritoService;
	
	@GetMapping("/listaDirentrega_usuario")
	public String listaDirentrega_usuario(Model model) {
		
		List<Direntrega_Usuario> listaDirentrega_usuario = direntrega_usuarioService.listar();
		
		model.addAttribute("listaDirentrega_usuario",listaDirentrega_usuario);
		
		return "listaDirentrega_usuario";
	}
	
	@GetMapping("/nuevoDirentrega_usuario")
	public String nuevoDirentrega_usuario (Model model) {
		
		
		List<Distrito> listaDistrito = distritoService.listarDistrito();
		List<Usuario> listaUsuario = usuarioService.listarUsuario();
		
		Direntrega_Usuario direntrega_usuario = new Direntrega_Usuario();
		direntrega_usuario.setFecharegDirentrega(new Date(new java.util.Date().getTime()));
		direntrega_usuario.setEstadoDirentrega("ACTIVO");
		
		
		model.addAttribute("direntrega_usuario",direntrega_usuario);
		model.addAttribute("listaDistrito",listaDistrito);
		model.addAttribute("listaUsuario",listaUsuario);
		
		return "registraDirentrega_usuario";
	};
	
	@PostMapping("/grabarDirentrega_usuario")
	public String grabarDirentrega_usuario (@ModelAttribute("direntrega") Direntrega_Usuario obj,Model model,HttpSession session){
		
		String mensaje = "";
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		obj.setUsuario(usuario);
		
		direntrega_usuarioService.agregar(obj);
		
		model.addAttribute("mensaje",mensaje);
		
		return "redirect:/listaDirentrega_usuario";
	}
	
}
