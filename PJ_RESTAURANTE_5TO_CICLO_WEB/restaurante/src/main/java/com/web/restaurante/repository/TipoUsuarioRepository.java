package com.web.restaurante.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.restaurante.model.TipoUsuario;
import java.util.List;


@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
	TipoUsuario findByIdTipoUsuario(int idTipoUsuario);
}
