package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Compra;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{
	
}
