package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.restaurante.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador,Integer>{
	
	public Colaborador finByIdColaborador(int id);
	
}
