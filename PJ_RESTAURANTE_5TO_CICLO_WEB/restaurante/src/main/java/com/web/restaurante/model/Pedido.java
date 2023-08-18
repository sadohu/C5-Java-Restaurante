package com.web.restaurante.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column(name="id_usuario_cliente")
	private Usuario UsuarioCliente;
	@Column(name="id_direntrega")
	private Direntrega_Usuario DirentregaUsuario;
	@Column(name = "id_colaborador_repartidor")
	private Colaborador ColaboradorRepartidor;
	@Column(name = "tiempoentrega_pedido")
	private double tiempoEntregaPedido;
	@Column(name = "fechareg_pedido")
	private Date fecharegPedido;
	@Column(name="fechaact_pedido")
	private Date fechaactPedido;
	@Column(name = "estado_pedido")
	private String estadoPedido;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pedido")
	private List<Producto_Pedido> listaProducto_Pedido;
}
