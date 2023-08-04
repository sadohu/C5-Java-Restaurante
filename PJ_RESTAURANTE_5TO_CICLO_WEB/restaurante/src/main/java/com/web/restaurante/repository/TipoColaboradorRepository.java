package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.TipoColaborador;
import java.util.List;


@Repository
public interface TipoColaboradorRepository extends JpaRepository<TipoColaborador, Integer> {
	
	TipoColaborador findByIdTipoColaborador(int idTipoColaborador);
}
