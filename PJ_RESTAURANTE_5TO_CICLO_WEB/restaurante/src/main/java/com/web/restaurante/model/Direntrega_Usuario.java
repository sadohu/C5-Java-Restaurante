package com.web.restaurante.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_direntrega_usuario")

@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Direntrega_Usuario_PK.class)
public class Direntrega_Usuario {
	@Id
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario idUsuario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_direntrega")
	private int idDirentrega;
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito distrito;
	private String des_direntrega;
	@Column(name="fechareg_direntrega")
	private Date fechareg_direntrega;
	@Column(name="estado_direntegra")
	private String estado_direntrega;
}
