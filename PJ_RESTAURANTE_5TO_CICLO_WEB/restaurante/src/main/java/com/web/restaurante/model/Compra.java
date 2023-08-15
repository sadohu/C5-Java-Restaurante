package com.web.restaurante.model;

import java.util.Date;

import jakarta.persistence.Column;
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
	@Column(name = "id_compra")
	private int id_compra;
	@Column(name = "id_pedido")
	private int id_pedido;
	@Column(name = "id_medio_pago")
	private int idMedioPago;
	@Column(name = "monto_compra")
	private double montoCompra;
	@Column(name = "fechareg_compra")
	private Date fecharegCompra;
	@Column(name = "estado_compra")
	private String estadoCompra;
	
}
