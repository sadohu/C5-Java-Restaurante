package com.web.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.restaurante.business.ColaboradorService;
import com.web.restaurante.business.PedidoService;
import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.Pedido;
import com.web.restaurante.reuzable.EncodeBase64;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoservice;
	@Autowired (required = false)
	private UsuarioService service;
	@Autowired (required = false)
	private ColaboradorService colaboradorservice;
	//@Autowired
	// private falta direntrega 	
	
	@GetMapping("/")
	public String listadoPedido(Model model) {
		List<Pedido> listaPedido = pedidoservice.listarPedido();
		model.addAttribute("listaPedido",listaPedido);
		model.addAttribute("Base64",new EncodeBase64());
		return "pedido";
	}
	
	@GetMapping("/nuevoPedido")
	public String registroPedidoFormulario(Model model) {
		
		Pedido pedido = new Pedido();
		
		model.addAttribute("pedido",pedido);
		return "registroPedido";
	}
	
	@PostMapping("/guardarPedido")
	public String registroPedido(@ModelAttribute("pedido") Pedido pedido) {
	    pedidoservice.registrarPedido(pedido);
	    
	    return "redirect:/";
	}
	
	@GetMapping("/actualizarPedido/{id}")
	public String actualizarPedidoFormulario(@PathVariable(value="id") int id, Model model) {
		
		Pedido pedido = pedidoservice.listaPedidoPorId(id);
		
		model.addAttribute("pedido",pedido);
		
		return "actualizarPedido";
	}
	
	@GetMapping("/eliminarPedido/{id}")
	public String eliminarPedido(@PathVariable(value="id") int id) {
		
		pedidoservice.eliminarPedido(id);
		return "refirect:/";
	}
	
} //Fin de pedido controller
