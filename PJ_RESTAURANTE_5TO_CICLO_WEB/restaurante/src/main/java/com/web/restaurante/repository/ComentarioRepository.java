package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Comentario;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	
	Comentario findByIdComentario(int idComentario);

}
