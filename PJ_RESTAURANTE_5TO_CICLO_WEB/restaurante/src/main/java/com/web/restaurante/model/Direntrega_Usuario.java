package com.web.restaurante.model;

import java.sql.Date;

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
@Table(name="tb_direntega_usuario")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direntrega_Usuario {
	@Id
	@OneToMany
	@JoinColumn(name="id_usuario")
	private Usuario id_usuario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_direntrega;
	@JoinColumn(name="id_distrito")
	private Distrito id_distrito;
	private String des_direntrega;
	private Date fechareg_direntrega;
	private String estado_direntrega;
}
