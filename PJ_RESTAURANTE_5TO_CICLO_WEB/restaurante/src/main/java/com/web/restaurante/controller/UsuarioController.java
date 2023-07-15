package com.web.restaurante.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.restaurante.business.DistritoService;
import com.web.restaurante.business.TipoUsuarioService;
import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.reuzable.EncodeBase64;


@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	@Autowired(required = false)
	private DistritoService distritoService;
	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	@GetMapping("/listaUsuario")
	private String listaUsuario (Model model,@RequestParam(name="imagenBase64", required=false) String imagenBase64) {
		
		List<Usuario> listaUsuario = service.listarUsuario();
		
		model.addAttribute("listaUsuario",listaUsuario);
		
		model.addAttribute("Base64",new EncodeBase64());
		
		return "/listaUsuario";
	}
	
	@GetMapping("/registraUsuario")
	private String registrarUsuario(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setEstado_usuario("ACTIVO");
		usuario.setFechareg_usuario(new java.sql.Date(new java.util.Date().getTime()));
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("listaDistrito",distritoService.listarDistrito());
		model.addAttribute("listaTipoUsuario",tipoUsuarioService.listarTipoUsuario());
		
		return "/registraUsuario";
	}
	
	@GetMapping("/actualizaUsuario/{id}")
	private String actualizaUsuario(@PathVariable(value="id") int id, Model model) {
		Usuario usuario = service.buscarUsuario(id);
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("listaDistrito",distritoService.listarDistrito());
		model.addAttribute("listaTipoUsuario",tipoUsuarioService.listarTipoUsuario());
		return "/registraUsuario";
	}
	
	@PostMapping("grabarUsuario")
	private String actualizarUsuario (@RequestParam(name="imagen", required=false) MultipartFile imagen ,@ModelAttribute("usuario") Usuario usuario) {
		
		byte[] imagenByte= null;
		
		try {

			imagenByte = imagen.getBytes();
			usuario.setImagen_usuario(imagenByte);
			

		}catch(Exception ex) {
			
		}
		
		service.registrarUsuario(usuario);
		return "redirect:/listaUsuario";
	}
	

	
}
