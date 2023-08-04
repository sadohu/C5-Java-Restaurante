package com.web.restaurante.model;

import java.io.Serializable;
import java.sql.Date;

import com.web.restaurante.reuzable.PrimaryClustered;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_direntrega_usuario")


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(PrimaryClustered.class)
public class Direntrega_Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PrimaryClustered primaryClustered;
	
	@MapsId("id_usario")
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	@MapsId("id_direntrega")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_direntrega")
	private int idDirentrega;
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito distrito;
	@Column(name = "des_direntrega")
	private String desDirentrega;
	@Column(name="fechareg_direntrega")
	private Date fecharegDirentrega;
	@Column(name="estado_direntegra")
	private String estadoDirentrega;
}
