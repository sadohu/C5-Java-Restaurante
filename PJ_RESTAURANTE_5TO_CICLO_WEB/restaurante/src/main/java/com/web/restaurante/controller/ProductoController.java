package com.web.restaurante.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.web.restaurante.business.CategoriaProService;
import com.web.restaurante.business.ProductoService;
import com.web.restaurante.model.CategoriaProducto;
import com.web.restaurante.model.Producto;
@Controller
public class ProductoController {
	@Autowired
	private ProductoService service;
	//para combobox
	@Autowired
	private CategoriaProService serviceCat;
	
	@GetMapping("/")
	public String listadoEmpleados(Model model) {
		model.addAttribute("listaProductos",service.listaProducto());
		return "producto";
	}
	@GetMapping("/nuevoProducto")
	public String registroProductoFormulario(Model model) {
		//
		List<CategoriaProducto> dataCat=serviceCat.listaCateProducto();
		
		
		Producto producto=new Producto();
	
		model.addAttribute("producto",producto);
		model.addAttribute("cate",dataCat);
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
		//Llenamos combo
		 List<CategoriaProducto> dataCat=serviceCat.listaCateProducto();
		 model.addAttribute("cate",dataCat);
		 
	
		model.addAttribute("producto",producto);
		model.addAttribute("categoriaId",producto.getTipo().getId_categoria_producto());
		//y redireccionamos a la vista o html actualizaProducto
		return "actualizaProducto";
	}
	@GetMapping("/eliminarProducto/{id}")
	public String eliminaProducto(@PathVariable(value="id") int id) {
		
		service.eliminarProducto(id);

		return "redirect:/";
	}
	
	
}// Fin de producto controller
