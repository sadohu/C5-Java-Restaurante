package com.web.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.restaurante.business.PedidoService;
import com.web.restaurante.business.Producto_PedidoService;
import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Producto_Pedido;

@Controller
public class Producto_PedidoController {

	@Autowired
	private Producto_PedidoService producto_PedidoService;
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/listaProductoPedido/{id}")
	private String listaProductoPedido(@PathVariable(value="id") int id,Model model) {
		
		Pedido pedido = pedidoService.listaPedidoPorId(id);
		
		List<Producto_Pedido> listaProducto_pedido = producto_PedidoService.listarPorPedido(pedido) ;
		
		double totalPagar = 0.00;
		
		for(Producto_Pedido producto : listaProducto_pedido) {
			totalPagar += producto.getCantidadProducto() * producto.getProducto().getPreciouniProducto();
		}
		
		model.addAttribute("listaProducto_pedido",listaProducto_pedido);
		model.addAttribute("idPedido", id);
		model.addAttribute("totalPagar",totalPagar);
		
		
		return "/listaProducto_pedido";
	}
}
