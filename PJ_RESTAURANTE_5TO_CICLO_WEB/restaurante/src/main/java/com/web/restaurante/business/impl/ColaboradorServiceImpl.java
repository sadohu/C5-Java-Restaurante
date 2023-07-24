package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.ColaboradorService;
import com.web.restaurante.model.Colaborador;
import com.web.restaurante.repository.ColaboradorRepository;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

	private ColaboradorRepository colaboradorRepository;
	
	@Override
	public List<Colaborador> listar() {
		return colaboradorRepository.findAll();
	}

	@Override
	public Colaborador buscar(int id) {
		return colaboradorRepository.finByIdColaborador(id);
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
