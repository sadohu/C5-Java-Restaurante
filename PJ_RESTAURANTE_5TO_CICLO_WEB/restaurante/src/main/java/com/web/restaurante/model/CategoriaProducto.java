package com.web.restaurante.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_categoria_producto")
@Data
public class CategoriaProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria_producto")
	private int idCategoriaProducto;
	@Column(name="des_categoria_producto")
	private String desCategoriaProducto;
	@JsonIgnore
	@OneToMany(mappedBy="cate")
	//Cada One to Many tiene siempre una lista de la otra tabla
	private List<Producto> listaProductos;
	
}
