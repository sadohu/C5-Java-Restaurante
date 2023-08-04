package com.web.restaurante.model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private int idUsuario;
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	@Column(name="cod_usuario")
	private String codUsuario;
	@Column(name="nom_usuario")
	private String nomUsuario;
	@Column(name="ape_usuario")
	private String apeUsuario;
	@Column(name="tel_usuario")
	private String telUsuario;
	@Column(name="cel_usuario")
	private String celUsuario;
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito distritoUsuario;
	@Column(name="dir_usuario")
	private String dirUsuario;
	@Column(name="dni_usuario")
	private String dniUsuario;
	@Column(name="email_usuario")
	private String emailUsuario;
	@Column(name="password_usuario")
	private String passwordUsuario;
	@Lob
	@Column(name="imagen_usuario")
	private byte[] imagenUsuario ;
	@Column(name="fechareg_usuario")
	private Date fecharegUsuario;
	@Column(name="fechaact_usuario")
	private Date fechaactUsuario;
	@Column(name="estado_usuario")
	private String estadoUsuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idUsuario")
	private List<Direntrega_Usuario> listaDirentrega;
	
	
}
