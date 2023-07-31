package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.CategoriaProducto;

@Repository
public interface CategoriaProRepository extends JpaRepository<CategoriaProducto, Integer>{

}
