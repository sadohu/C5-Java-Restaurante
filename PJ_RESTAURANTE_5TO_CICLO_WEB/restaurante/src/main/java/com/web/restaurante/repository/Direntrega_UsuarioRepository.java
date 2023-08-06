package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Direntrega_Usuario;
import java.util.List;
import com.web.restaurante.reuzable.PrimaryClustered;



@Repository
public interface Direntrega_UsuarioRepository extends JpaRepository<Direntrega_Usuario, Integer> {
	
	Direntrega_Usuario findByIdDirentrega(int idDirentrega);
	Direntrega_Usuario findByPrimaryClustered(PrimaryClustered primaryClustered);
	

}
