package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.Direntrega_UsuarioService;
import com.web.restaurante.model.Direntrega_Usuario;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.repository.Direntrega_UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Direentrega_UsuarioServiceImpl implements Direntrega_UsuarioService {

	private Direntrega_UsuarioRepository direntrega_usuarioRepository;
	
	@Override
	public List<Direntrega_Usuario> listar() {
		return direntrega_usuarioRepository.findAll();
	}

	@Override
	public Direntrega_Usuario buscar(int idHeredado, int idPropio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregar(Direntrega_Usuario obj) {
		direntrega_usuarioRepository.save(obj);
	}

	@Override
	public void editar(Direntrega_Usuario obj) {
		direntrega_usuarioRepository.save(obj);
	}

	@Override
	public void eliminar(int idHeredado, int idPropio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Direntrega_Usuario> listarPorUsuario(Usuario usuario) {
		return direntrega_usuarioRepository.findByUsuario(usuario);
	}

	@Override
	public Direntrega_Usuario buscarPorIdDerentrega(int id) {
		return direntrega_usuarioRepository.findByIdDirentrega(id);
	}

	

}
