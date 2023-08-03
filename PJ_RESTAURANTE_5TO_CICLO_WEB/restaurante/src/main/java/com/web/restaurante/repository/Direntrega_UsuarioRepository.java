package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.restaurante.model.Direntrega_Usuario;

public interface Direntrega_UsuarioRepository extends JpaRepository<Direntrega_Usuario, Integer> {
	
	Direntrega_Usuario findById_direntrega(int id_direntrega);
	
}
