package com.web.restaurante.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="tb_tipo_colaborador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoColaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_colaborador")
	private int id;
	private String des_tipo_colaborador;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipo_colaborador")
	private List<Colaborador> listaColaborador;
	
}
