package com.web.restaurante.model;

import java.sql.Date;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="tb_colaborador")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_colaborador;
	@ManyToOne
	@JoinColumn(name = "id_tipo_colaborador")
	private int tipo_colaborador;
	private String nom_colaborador;
	private String ape_colaborador;
	private String dni_colaborador;
	@Lob
	private byte[] imagen_colaborador;
	private Date fechareg_colaborador;
	private Date fechaact_colaborador;
	private String estado_colaborador;
}
