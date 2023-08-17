package com.web.restaurante.model;

import lombok.Data;

@Data
public class Producto_Pedido {

	int idPedido;
	private int idProductoPedido;
	private int idProducto;
	private int cantidadProducto;
}
