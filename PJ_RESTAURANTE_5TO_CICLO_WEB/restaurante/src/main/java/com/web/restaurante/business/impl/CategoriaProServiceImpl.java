package com.web.restaurante.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.business.CategoriaProService;
import com.web.restaurante.model.CategoriaProducto;
import com.web.restaurante.repository.CategoriaProRepository;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaProServiceImpl implements CategoriaProService  {
	
	private CategoriaProRepository repository;
	
	@Override
	public List<CategoriaProducto> listaCateProducto() {
		return repository.findAll();
	}

}
