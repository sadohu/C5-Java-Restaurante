package com.web.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_mediopago")
@Data
public class MedioPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_medioPago;
	private String des_medioPago;
}
