package com.web.restaurante.business;

import com.web.restaurante.model.Compra;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.reuzable.Crud;
import java.util.List;

public interface CompraService extends Crud<Compra>{
	public List<Compra> listarPorUsuario(Usuario usuario);
}
