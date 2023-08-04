package com.web.restaurante.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_tipo_usuario")
@Data
public class TipoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_usuario")
	private int idTipoUsuario;
	@Column(name="des_tipo_usuario")
	private String desTipoUsuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> listaUsuario;
	
}
