package com.web.restaurante.business.impl;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository repository;

	@Override
	public List<Usuario> listarUsuario() {
		
		return repository.findAll();
	}

	@Override
	public void registrarUsuario(Usuario obj) {
		
		repository.save(obj);
	}

	@Override
	public void eliminarUsuario(int id) {

		repository.deleteById(id);
		
	}

	@Override
	public Usuario buscarUsuario(int id) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repository.findById(id);
		Usuario obj = null;
		
		if(optional.isPresent()) {
			obj = optional.get();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario no fue encontrado");
		}
		
		return obj;
	}

}
