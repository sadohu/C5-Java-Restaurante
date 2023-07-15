package com.web.restaurante.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.restaurante.model.Distrito;

public interface DistritoService {
	public List<Distrito> listarDistrito();
	public Distrito buscarDistrito(int id);
}
