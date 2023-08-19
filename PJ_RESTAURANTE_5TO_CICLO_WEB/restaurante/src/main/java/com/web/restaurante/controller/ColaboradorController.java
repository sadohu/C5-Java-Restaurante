package com.web.restaurante.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.web.restaurante.business.ColaboradorService;
import com.web.restaurante.business.TipoColaboradorService;
import com.web.restaurante.model.Colaborador;
import com.web.restaurante.model.TipoColaborador;
import com.web.restaurante.reuzable.EncodeBase64;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;
	@Autowired
	private TipoColaboradorService tipoColaboradorService;

	@GetMapping("/listaColaborador")
	public String listaColaborador(Model model) {
		
		List<Colaborador> listaColaborador = colaboradorService.listar();
		
		model.addAttribute("listaColaborador",listaColaborador);
		model.addAttribute("Base64",new EncodeBase64());
		
		nuevoColaborador(model);
		
		return "listaColaborador";
	}
	
	@GetMapping("/nuevoColaborador")
	public String nuevoColaborador(Model model) {
		
		List<TipoColaborador> listaTipoColaborador = tipoColaboradorService.listar();

		Colaborador colaborador = new Colaborador();
		colaborador.setFecharegColaborador(new Date(new java.util.Date().getTime()));
		colaborador.setEstadoColaborador("ACTIVO");
		
		model.addAttribute("colaborador",colaborador);
		model.addAttribute("listaTipoColaborador",listaTipoColaborador);
		
		return "registraColaborador";
	}
	
	@GetMapping("/actualizarColaborador/{id}")
	public String actualizarColaborador(@PathVariable("id")int id, Model model) {
		
		Colaborador colaborador = colaboradorService.buscar(id);
		int idTipoColaborador = colaborador.getTipoColaborador().getIdTipoColaborador();
		List<TipoColaborador> listaTipoColaborador = tipoColaboradorService.listar();
		
		model.addAttribute("colaborador",colaborador);
		model.addAttribute("listaTipoColaborador",listaTipoColaborador);
		model.addAttribute("idTipoColaborador", idTipoColaborador);
		
		return "registraColaborador";
	}
	
	@PostMapping("grabarColaborador")
	public String grabarColaborador(@ModelAttribute("colaborador") Colaborador obj, MultipartFile imagen) throws IOException {
		
		obj.setImagenColaborador(imagen.getBytes());
		colaboradorService.agregar(obj);
		
		return "redirect:/listaColaborador";
	}
}
