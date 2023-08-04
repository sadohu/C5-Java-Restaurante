package com.web.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	
	@GetMapping("/loginRestaurante")
	private String login (Model model) {
		
		model.addAttribute("usuario",new Usuario());
		//session.invalidate();
		//session.removeAttribute("usuario");
		
		return "loginRestaurante";
	}
	
	@PostMapping("/iniciarSesion")
	private String iniciarSesion(@ModelAttribute("usuario") Usuario usuario,Model model) {
		
		List<Usuario> listaUsuario= service.listarUsuario(); 
		String codigo_usuario = usuario.getCodUsuario();
		String password_usuario = usuario.getPasswordUsuario();
		
		for (Usuario obj :listaUsuario) {
			if(obj.getCodUsuario().equals(codigo_usuario) && obj.getPasswordUsuario().equals(password_usuario)) {
				
				model.addAttribute("accesoCorrecto",obj.getNomUsuario());
				model.addAttribute("imagen_usuario",new EncodeBase64().base64ToString(obj.getImagenUsuario()));
				
				//session.setAttribute("usuario", obj);
				
				return "/index";
			}
		}
		
		model.addAttribute("error","Las credenciales no son correctas");
		return "loginRestaurante";
	}
	
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
		usuario.setEstadoUsuario("ACTIVO");
		usuario.setFecharegUsuario(new java.sql.Date(new java.util.Date().getTime()));
		
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
			usuario.setImagenUsuario(imagenByte);
			

		}catch(Exception ex) {
			
		}
		
		service.registrarUsuario(usuario);
		return "redirect:/listaUsuario";
	}
	

	
}
