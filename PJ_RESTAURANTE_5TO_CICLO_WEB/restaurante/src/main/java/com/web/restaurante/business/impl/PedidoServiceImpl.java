package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.PedidoService;
import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.repository.PedidoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

	private PedidoRepository repository;
	
	@Override
	public List<Pedido> listarPedido() {
		
		return repository.findAll();
	}

	@Override
	public void registrarPedido(Pedido pedido) {
		
		repository.save(pedido);	
	}

	@Override
	public void eliminarPedido(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Pedido listaPedidoPorId(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void registrarPedidos(List<Pedido> pedidos) {
		repository.saveAll(pedidos);
		
	}

	@Override
	public Pedido buscarUltimoPedidoPorUsuarioCliente(Usuario ususarioCliente) {
		
		return repository.findByUsuarioCliente(ususarioCliente).get(repository.findByUsuarioCliente(ususarioCliente).size()-1);
	}

	@Override
	public List<Pedido> listarPorUsuario(Usuario usuario) {
		
		List<Pedido> lista = repository.findByUsuarioCliente(usuario);
		
		
		
		return lista;
	}

}
