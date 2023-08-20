package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.MedioPagoService;
import com.web.restaurante.model.MedioPago;
import com.web.restaurante.repository.MedioPagoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedioPagoServiceImpl implements MedioPagoService {
	
	private MedioPagoRepository medioPagoRepository;
	
	@Override
	public List<MedioPago> listar() {
		return medioPagoRepository.findAll();
	}

	@Override
	public MedioPago buscar(int id) {
		return medioPagoRepository.findById(id).get();
	}

	@Override
	public void agregar(MedioPago obj) {
		medioPagoRepository.save(obj);
	}

	@Override
	public void editar(MedioPago obj) {
		medioPagoRepository.save(obj);
	}

	@Override
	public void eliminar(int id) {
		medioPagoRepository.deleteById(id);
	}

}
