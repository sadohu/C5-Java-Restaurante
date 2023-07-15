package com.web.restaurante.business.impl;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.DistritoService;
import com.web.restaurante.model.Distrito;
import com.web.restaurante.repository.DistritoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DistritoServiceImpl implements DistritoService {

	DistritoRepository repository;
	
	
	@Override
	public List<Distrito> listarDistrito() {
		return repository.findAll();
	}

	@Override
	public Distrito buscarDistrito(int id) {
		// TODO Auto-generated method stub
		Optional<Distrito> optional = repository.findById(id);
		
		Distrito obj = null;
		
		if(optional.isPresent()) {
			obj = optional.get();
		}else {
			JOptionPane.showMessageDialog(null, "Distrito no fue encontrado");
		}
		
		return obj;
	}

}
