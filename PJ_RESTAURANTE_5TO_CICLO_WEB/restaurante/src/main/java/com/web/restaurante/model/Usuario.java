package com.web.restaurante.model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.Base64;

import javax.imageio.stream.FileImageInputStream;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int id_usuario;
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipo_usuario;
	private String cod_usuario;
	private String nom_usuario;
	private String ape_usuario;
	private String tel_usuario;
	private String cel_usuario;
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito distrito_usuario;
	private String dir_usuario;
	private String dni_usuario;
	private String email_usuario;
	private String password_usuario;
	@Lob
	private byte[] imagen_usuario ;
	private Date fechareg_usuario;
	private Date fechaact_usuario;
	private String estado_usuario;
	
	
	
	
}
