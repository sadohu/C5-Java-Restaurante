package com.web.restaurante.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.restaurante.business.ProductoService;
import com.web.restaurante.model.Producto;
import com.web.restaurante.reuzable.EncodeBase64;
@Controller
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@GetMapping("/1")
	public String listadoEmpleados(Model model) {
		model.addAttribute("listaProductos",service.listaProducto());
		model.addAttribute("Base64",new  EncodeBase64());
		return "producto";
	}
	@GetMapping("/nuevoProducto")
	public String registroProductoFormulario(Model model) {

		Producto producto=new Producto();
	
		model.addAttribute("producto",producto);
		//retornamos a la vista registroEmpleado
		return "registroProducto";
	}
	@PostMapping("/guardarProducto")
	public String registroProducto(@ModelAttribute("producto") Producto producto) {
		
		service.registrarProducto(producto);
	
		return "redirect:/";
	}
	
	@GetMapping("/actualizaProducto/{id}") 
	public String actualizaProductoFormulario(@PathVariable(value="id") int id,Model model) {
	
		Producto producto=service.listaProductoPorId(id);

		model.addAttribute("producto",producto);
		//y redireccionamos a la vista o html actualizaEmpleado
		return "actualizaEmpleado";
	}
	@GetMapping("/eliminarProducto/{id}")
	public String eliminaProducto(@PathVariable(value="id") int id) {
		
		service.eliminarProducto(id);

		return "redirect:/";
	}
	
	
}// Fin de producto controller
