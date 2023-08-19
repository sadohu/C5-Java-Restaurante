package com.web.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Pedido;
import com.web.restaurante.model.Producto_Pedido;

@Repository
public interface Producto_PedidoRepository extends JpaRepository<Producto_Pedido, Integer> {
	List<Producto_Pedido> findByPedido(Pedido pedido);
}
