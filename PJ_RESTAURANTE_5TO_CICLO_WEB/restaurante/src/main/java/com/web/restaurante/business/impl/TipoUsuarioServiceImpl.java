package com.web.restaurante.business.impl;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.TipoUsuarioService;
import com.web.restaurante.model.TipoUsuario;
import com.web.restaurante.repository.TipoUsuarioRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	
	TipoUsuarioRepository repository;
	
	@Override
	public List<TipoUsuario> listarTipoUsuario() {
		return repository.findAll();
	}

	@Override
	public TipoUsuario buscarTipoUsuario(int id) {
		
		Optional<TipoUsuario> optional = repository.findById(id);
		TipoUsuario obj = null;
		if(optional.isPresent()) {
			obj = optional.get();
		}else {
			JOptionPane.showMessageDialog(null, "Tipo de usuario no encontrado");
		}
		
		return obj;
	}

}
