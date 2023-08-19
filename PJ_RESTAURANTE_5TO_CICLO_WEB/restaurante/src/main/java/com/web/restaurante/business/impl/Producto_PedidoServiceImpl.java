package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.Producto_PedidoService;
import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Producto;
import com.web.restaurante.model.Producto_Pedido;
import com.web.restaurante.repository.Producto_PedidoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Producto_PedidoServiceImpl implements Producto_PedidoService {

	Producto_PedidoRepository producto_PedidoRepository;
	

	@Override
	public List<Producto_Pedido> listar() {
		return producto_PedidoRepository.findAll();
	}

	@Override
	public Producto_Pedido buscar(int idHeredado, int idPropio) {
		return null;
	}

	@Override
	public void agregar(Producto_Pedido obj) {
		producto_PedidoRepository.save(obj);
	}

	@Override
	public void editar(Producto_Pedido obj) {
		producto_PedidoRepository.save(obj);
	}

	@Override
	public void eliminar(int idHeredado, int idPropio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarProductos(List<Producto_Pedido> productos) {
		producto_PedidoRepository.saveAll(productos);
	}

	@Override
	public List<Producto_Pedido> listarPorPedido(Pedido pedido) {
		return producto_PedidoRepository.findByPedido(pedido);
	}
	

}
