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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
@Entity
@Table(name = "tb_tipo_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
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
