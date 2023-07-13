package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.restaurante.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
