package com.web.restaurante.business;

import java.util.List;

import com.web.restaurante.model.Usuario;

public interface UsuarioService {

	public List<Usuario> listarUsuario();
	public void adicionarUsuario(Usuario obj);
	public void editarUsuario(Usuario obj);
	public void eliminarUsuario(int id);
	public Usuario buscarUsuario(int id);
	
}
