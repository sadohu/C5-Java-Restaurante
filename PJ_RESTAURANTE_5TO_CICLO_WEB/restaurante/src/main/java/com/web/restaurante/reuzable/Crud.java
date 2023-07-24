package com.web.restaurante.reuzable;

import java.util.List;

public interface Crud<T> {
	
	public List<T> listar();
	public T buscar(int id);
	public void agregar(T obj);
	public void editar(T obj);
	public void eliminar(int id);
	
	
}
