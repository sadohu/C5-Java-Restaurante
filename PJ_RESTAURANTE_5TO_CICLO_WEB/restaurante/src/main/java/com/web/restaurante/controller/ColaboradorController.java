package com.web.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.restaurante.business.ColaboradorService;
import com.web.restaurante.model.Colaborador;
@Controller
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping("/listaColaborador")
	public String listaColaborador(Model model) {
		
		List<Colaborador> listaColaborador = colaboradorService.listar();
		
		model.addAttribute("listaColaborador",listaColaborador);
		
		return "listaColaborador";
	}
}
