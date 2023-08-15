package com.web.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.Usuario;
import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	 Usuario findByIdUsuario(int idUsuario); 
	Usuario findByEmailUsuario (String email);
	
	
}
