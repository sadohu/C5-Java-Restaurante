package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.TipoColaboradorService;
import com.web.restaurante.model.TipoColaborador;
import com.web.restaurante.repository.TipoColaboradorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoColaboradorServiceImpl implements TipoColaboradorService {

	private TipoColaboradorRepository tipoColaboradorRepository;
	
	@Override
	public List<TipoColaborador> listar() {
		return tipoColaboradorRepository.findAll();
	}

	@Override
	public TipoColaborador buscar(int id) {
		return tipoColaboradorRepository.finByIdTipoColaborador(id);
	}

	@Override
	public void agregar(TipoColaborador obj) {
		tipoColaboradorRepository.save(obj);
	}

	@Override
	public void editar(TipoColaborador obj) {
		tipoColaboradorRepository.save(obj);
	}

	@Override
	public void eliminar(int id) {
		TipoColaborador obj = buscar(id);
		tipoColaboradorRepository.delete(obj);
	}
	
}
