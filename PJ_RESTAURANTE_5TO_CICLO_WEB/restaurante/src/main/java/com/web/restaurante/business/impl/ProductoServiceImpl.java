package com.web.restaurante.business.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.web.restaurante.business.ProductoService;
import com.web.restaurante.model.Producto;
import com.web.restaurante.repository.ProductoRepository;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {
	
		private ProductoRepository repository;

		@Override
		public List<Producto> listaProducto() {
		
			return repository.findAll();
		}

		@Override
		public void registrarProducto(Producto producto) {
		
			repository.save(producto);
			
		}

		@Override
		public Producto listaProductoPorId(int id) {
			
			Optional<Producto> objeto=repository.findById(id);
			
			Producto producto=null;
			//validamos si objeto es present no es nulo entonces coge el valor
			if(objeto.isPresent()) {
				producto=objeto.get();
			}
			//en caso sea nulo , lanzaremos excepcion con mensaje
			else {
				throw new RuntimeException ("Producto con el id "+  id + "no fue encontrado !!!");
			}
			
			return producto;
		}

		@Override
		public void eliminarProducto(int id) {
			
			repository.deleteById(id);	
		}

}
