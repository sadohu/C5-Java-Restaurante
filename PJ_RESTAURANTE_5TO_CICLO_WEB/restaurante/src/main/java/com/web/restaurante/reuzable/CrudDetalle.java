package com.web.restaurante.reuzable;

import java.util.List;

public interface CrudDetalle<T> {
	
	public List<T> listar();
	public T buscar(int idHeredado, int idPropio);
	public void agregar(T obj);
	public void editar(T obj);
	public void eliminar(int idHeredado, int idPropio);
	
	
}
