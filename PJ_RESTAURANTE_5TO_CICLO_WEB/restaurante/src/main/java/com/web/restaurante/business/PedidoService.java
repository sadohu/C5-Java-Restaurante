package com.web.restaurante.business;

import java.util.List;
import com.web.restaurante.model.Pedido;

public interface PedidoService {
	
	public List<Pedido> listarPedido();
	public void registrarPedido(Pedido obj);
	public void eliminarPedido(int id);
	public Pedido listaPedidoPorId(int id);

}
