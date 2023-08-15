package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.ComentarioService;
import com.web.restaurante.model.Comentario;
import com.web.restaurante.repository.ComentarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

	private ComentarioRepository comentarioRepository;
	
	@Override
	public List<Comentario> listar() {
		return comentarioRepository.findAll();
	}

	@Override
	public Comentario buscar(int id) {
		return comentarioRepository.findByIdComentario(id);
	}

	@Override
	public void agregar(Comentario obj) {
		comentarioRepository.save(obj);
	}

	@Override
	public void editar(Comentario obj) {
		comentarioRepository.save(obj);
	}

	@Override
	public void eliminar(int id) {
		Comentario obj = buscar(id);
		comentarioRepository.delete(obj);
	}

}
