package com.web.restaurante.business;

import java.util.List;

import com.web.restaurante.model.TipoUsuario;

public interface TipoUsuarioService {
	
	public List<TipoUsuario> listarTipoUsuario();
	public TipoUsuario buscarTipoUsuario(int id);
	
}
