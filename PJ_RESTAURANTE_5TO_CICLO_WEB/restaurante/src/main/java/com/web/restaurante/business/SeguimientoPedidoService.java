package com.web.restaurante.business;

import java.util.List;

import com.web.restaurante.model.SeguimientoPedido;

public interface SeguimientoPedidoService {
	
	public List<SeguimientoPedido> listarSeguimientoPedido();
	public SeguimientoPedido buscarSeguimientoPedido(int id); 

}
