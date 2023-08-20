package com.web.restaurante.model;

import java.io.Serializable;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_mediopago")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedioPago implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medio_pago")
	private int idMedioPago;
	@Column(name = "des_medio_pago")
	private String desMedioPago;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medioPago")
	private List<Compra> listaCompra;
}
