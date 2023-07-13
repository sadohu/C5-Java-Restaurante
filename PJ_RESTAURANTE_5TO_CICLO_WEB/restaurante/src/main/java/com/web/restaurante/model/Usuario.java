package com.web.restaurante.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	private int id_tipo_usuario;
	private String nom_usuario;
	private String ape_usuario;
	private int tel_usuario;
	private int cel_usuario;
	private int id_distrito;
	private String dir_usuario;
	private String dni_usuario;
	private String email_usuario;
	private String password_usuario;
	private String imagen_usuario;
	private Date fecharReg_usuario;
	private Date fechaAct_usuario;
	private String estado_usuario;
}
