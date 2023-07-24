package com.web.restaurante.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_seguimiento_pedido")
@Data 
public class SeguimientoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	private int id_seguimiento_pedido;
	private Date fechareg_seguimiento_pedido;
	private Date esatdo_seguimiento_pedido;
	
}
