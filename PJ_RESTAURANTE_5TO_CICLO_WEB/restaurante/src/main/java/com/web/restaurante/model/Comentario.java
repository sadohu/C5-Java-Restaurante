package com.web.restaurante.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_comentario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comentario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario")
	public int idComentario;
	@ManyToOne
	@JoinColumn(name="id_usuario_cliente")
	public Usuario usuarioCliente;
	@Column(name="des_comentario")
	public String desComentario;
	@Column(name="cantestrella_comentario")
	public int cantEstrellaComentario;
	@Column(name="fechareg_comentario")
	public Date fecharegComentario;
	@Column(name = "estado_comentario")
	public String estadoComentario;
}
