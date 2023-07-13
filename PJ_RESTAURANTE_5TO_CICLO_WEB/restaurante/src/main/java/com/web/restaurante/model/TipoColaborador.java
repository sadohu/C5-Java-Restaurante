package com.web.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="tb_tipo_colaborador")
@Data
public class TipoColaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_colaborador;
	private String des_tipo_colaborador;
	
}
