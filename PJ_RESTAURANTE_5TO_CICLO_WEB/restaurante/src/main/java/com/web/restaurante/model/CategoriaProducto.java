package com.web.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_categoria_producto")
@Data
public class CategoriaProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_categoria_producto;
	private String des_categoria_producto;
}
