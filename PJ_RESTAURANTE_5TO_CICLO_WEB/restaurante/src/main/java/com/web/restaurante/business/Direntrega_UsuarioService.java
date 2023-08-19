package com.web.restaurante.business;

import java.util.List;

import com.web.restaurante.model.Direntrega_Usuario;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.reuzable.Crud;
import com.web.restaurante.reuzable.CrudDetalle;

public interface Direntrega_UsuarioService extends CrudDetalle<Direntrega_Usuario> {
	public List<Direntrega_Usuario> listarPorUsuario(Usuario usuario);
	public Direntrega_Usuario buscarPorIdDerentrega (int id);
}
