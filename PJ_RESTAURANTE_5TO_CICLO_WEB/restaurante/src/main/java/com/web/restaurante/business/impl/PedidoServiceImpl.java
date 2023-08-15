package com.web.restaurante.business.impl;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

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
		// TODO Auto-generated method stub
		Optional<Pedido> optional = repository.findById(id);
		Pedido obj = null;
				
		if(optional.isPresent()) {
			obj = optional.get();
		}else {	
			JOptionPane.showMessageDialog(null, "Pedido no fue encontrado :'( ");
		}
		
		return obj;
	}

}
