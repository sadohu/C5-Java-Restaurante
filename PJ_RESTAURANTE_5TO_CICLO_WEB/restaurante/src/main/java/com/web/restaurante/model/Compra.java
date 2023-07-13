package com.web.restaurante.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "tb_compra")
@Data
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_compra;
	private int id_pedido;
	private int id_medioPago;
	private double monto_compra;
	private Date fechaReg_compra;
	private String estado_compra;
	
}
