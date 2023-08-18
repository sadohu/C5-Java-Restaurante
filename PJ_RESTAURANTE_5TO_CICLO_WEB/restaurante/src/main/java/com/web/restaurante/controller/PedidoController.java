package com.web.restaurante.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.restaurante.business.ColaboradorService;
import com.web.restaurante.business.PedidoService;
import com.web.restaurante.business.ProductoService;
import com.web.restaurante.business.Producto_PedidoService;
import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Producto;
import com.web.restaurante.model.Producto_Pedido;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.repository.ProductoRepository;
import com.web.restaurante.reuzable.EncodeBase64;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired (required = false)
	private UsuarioService usuarioService;
	@Autowired (required = false)
	private ColaboradorService colaboradorService;
	@Autowired
	private Producto_PedidoService producto_PedidoService;
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listaPedido")
	public String listadoPedido(Model model) {
		List<Pedido> listaPedido = pedidoService.listarPedido();
		model.addAttribute("listaPedido",listaPedido);
		model.addAttribute("Base64",new EncodeBase64());
		return "listaPedido";
	}
	
	@GetMapping("/nuevoPedido")
	public String registroPedidoFormulario(Model model, HttpSession session) {
		Usuario usuarioSession =(Usuario)session.getAttribute("usuario");
		
		Pedido pedido = new Pedido();
		pedido.setEstadoPedido("ACTIVO");
		pedido.setFecharegPedido(new Date(new java.util.Date().getTime()));
		
		if(usuarioSession!=null) {
			pedido.setUsuarioCliente(usuarioSession);
		}
		
		
		model.addAttribute("pedido",pedido);
		return "registraPedido";
	}
	
	@PostMapping("/guardarPedido")
	public String registroPedido(@ModelAttribute("pedido") Pedido pedido,HttpSession session) {
		
		pedidoService.registrarPedido(pedido);
		
		
		Producto_Pedido producto_Pedido = new Producto_Pedido();
		List<Producto> productos = (List<Producto>)session.getAttribute("carrito");
		
		pedidoService.registrarPedido(pedido);
		
		int idProductoPedido=0;
		
		for (Producto producto : productos) {
			idProductoPedido ++;
			producto_Pedido = new Producto_Pedido();
			producto_Pedido.setIdProductoPedido(idProductoPedido);
			producto_Pedido.setProducto(producto);
			producto_Pedido.setCantidadProducto(1);
			
		}
		
	    return "redirect:/";
	}
	
	@GetMapping("/actualizarPedido/{id}")
	public String actualizarPedidoFormulario(@PathVariable(value="id") int id, Model model) {
		Pedido pedido = pedidoService.listaPedidoPorId(id);
		model.addAttribute("pedido",pedido);
		
		return "actualizarPedido";
	}
	
	@GetMapping("/eliminarPedido/{id}")
	public String eliminarPedido(@PathVariable(value="id") int id) {
		pedidoService.eliminarPedido(id);
		return "refirect:/";
	}
	
	
	@GetMapping("/carroCompra")
	public String carroCompra (Model model,HttpSession session) {
		
		
		
		return "carroCompra";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/agregarCarro{id}")
	public String llenarCarroCompra (@PathVariable(value="id")int id,Model model,HttpSession session){
			
		Producto producto = productoService.listaProductoPorId(id);
		
		((ArrayList<Producto_Pedido>)session.getAttribute("carrito")).add(producto);
		
		
		return "redirect:/listaProducto/cliente";
	}
	
	
} //Fin de pedido controller
