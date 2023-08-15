package com.web.restaurante.model;

import java.sql.Date;

import jakarta.persistence.Column;
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
	@Column(name = "id_pedido")
	private int idPedido;
	@Column(name="id_seguimiento_pedido")
	private int idSeguimientoPedido;
	@Column(name="fechareg_seguimiento_pedido")
	private Date fecharegSeguimientoPedido;
	@Column(name="estado_seguimiento_pedido")
	private Date estadoSeguimientoPedido;
	
}
