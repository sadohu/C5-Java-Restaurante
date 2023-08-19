package com.web.restaurante.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_colaborador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_colaborador")
	private int idColaborador;

	@ManyToOne
	@JoinColumn(name="id_tipo_colaborador")
	private TipoColaborador tipoColaborador;
	@Column(name = "nom_colaborador")
	private String nomColaborador;
	@Column(name = "ape_colaborador")
	private String apeColaborador;
	@Column(name = "dni_colaborador")
	private String dniColaborador;
	@Column(name = "imagen_colaborador")
	@Lob
	private byte[] imagenColaborador;
	@Column(name="fechareg_colaborador")
	private Date fecharegColaborador;
	@Column(name = "fechaact_colaborador")
	private Date fechaactColaborador;
	@Column(name = "estado_colaborador")
	private String estadoColaborador;
	
	@JsonIgnore
	@OneToMany(mappedBy = "colaboradorRepartidor")
	private List<Pedido> listaPedido ;
}
