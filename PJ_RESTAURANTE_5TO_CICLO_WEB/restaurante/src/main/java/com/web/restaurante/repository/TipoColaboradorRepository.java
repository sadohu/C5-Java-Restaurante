package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.restaurante.model.TipoColaborador;

public interface TipoColaboradorRepository extends JpaRepository<TipoColaborador, Integer> {
	public TipoColaborador finByIdTipoColaborador(int id);
}
