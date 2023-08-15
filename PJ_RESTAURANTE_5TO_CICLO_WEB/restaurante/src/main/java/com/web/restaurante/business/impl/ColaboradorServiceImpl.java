package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.ColaboradorService;
import com.web.restaurante.model.Colaborador;
import com.web.restaurante.repository.ColaboradorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColaboradorServiceImpl implements ColaboradorService {

	private ColaboradorRepository colaboradorRepository;
	
	@Override
	public List<Colaborador> listar() {
		return colaboradorRepository.findAll();
	}

	@Override
	public Colaborador buscar(int id) {
		return colaboradorRepository.findByIdColaborador(id);
	}

	@Override
	public void agregar(Colaborador obj) {
		colaboradorRepository.save(obj);
	}

	@Override
	public void editar(Colaborador obj) {
		colaboradorRepository.save(obj);
	}

	@Override
	public void eliminar(int id) {
		Colaborador obj = buscar(id);
		colaboradorRepository.delete(obj);
	}
	
	
	
}
