package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
