package com.web.restaurante.business;

import java.util.List;

import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Producto;
import com.web.restaurante.model.Producto_Pedido;
import com.web.restaurante.reuzable.CrudDetalle;

public interface Producto_PedidoService extends CrudDetalle<Producto_Pedido> {

	public void agregarProductos(List<Producto_Pedido> producto_Pedidos);
	
	public List<Producto_Pedido> listarPorPedido (Pedido pedido);
	
	public int getMontoTotalPorPedido(Pedido pedido);
}
