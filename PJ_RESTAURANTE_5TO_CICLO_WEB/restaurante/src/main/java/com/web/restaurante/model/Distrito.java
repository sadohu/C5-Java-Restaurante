package com.web.restaurante.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_distrito")
@Data
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_distrito;
	private String des_distrito;
	
	@JsonIgnore
	@OneToMany(mappedBy = "distrito_usuario")
	private List<Usuario> listaUsuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idDirentrega")
	private List<Direntrega_Usuario> listaDirentrega;
	
}
