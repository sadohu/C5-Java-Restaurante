package com.web.restaurante.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pedido")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private int idPedido;
	@Column(name="id_usuario")
	private Usuario idUsuario;
	@Column(name="id_direntrega")
	private Direntrega_Usuario idDirentregaPedido;
	@Column(name = "id_colaborador")
	private Colaborador idColaborador;
	@Column(name = "tiempoentrega_pedido")
	private double tiempoEntregaPedido;
	@Column(name = "fechareg_pedido")
	private Date fechareg_pedido;
	@Column(name="fechaact_pedido")
	private Date fechaact_pedido;
	@Column(name = "estado_pedido")
	private String estado_pedido;
}
