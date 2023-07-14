package com.web.restaurante.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int id_usuario;
	//private int id_tipo_usuario; //FORANEA (Muchos usuarios de un tipo)
	private String nom_usuario;
	private String ape_usuario;
	private int tel_usuario;
	private int cel_usuario;
	//private int id_distrito; //FORANEA (Muchos usuario de un distrito )
	private String dir_usuario;
	private String dni_usuario;
	private String email_usuario;
	private String password_usuario;
	private byte[] imagen_usuario;
	private Date fechareg_usuario;
	private Date fechaact_usuario;
	private String estado_usuario;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipo_usuario;
	
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito distrito_usuario;
}
