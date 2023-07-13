package com.web.restaurante.business;
import java.util.List;

import com.web.restaurante.model.Producto;
public interface ProductoService {
	//Creamos metodos para CRUD
	
		
		List<Producto> listaProducto();
	
		void registrarProducto(Producto producto);
		//listar por ID
		Producto listaProductoPorId(int id);
		//eliminar
		void eliminarProducto(int id);
			
}
