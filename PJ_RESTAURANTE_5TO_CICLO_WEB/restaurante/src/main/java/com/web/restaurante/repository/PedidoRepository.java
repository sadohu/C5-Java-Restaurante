package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Usuario;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByUsuarioCliente(Usuario usuarioCliente);
	
}
