package com.web.restaurante.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int id;
	
	private String nom_producto;
	private String des_producto;
	private double preciouni_producto;
	private int stock_producto;
	private byte[] imagen_producto;
	private String estado_producto;
	
	@ManyToOne
	@JoinColumn(name="id_categoria_producto")
	//variable ASOCIACION ENTRE TABLAS este es un Objeto de CategoriaProducto
	private CategoriaProducto tipo;//Donde este nombre tipo es la ASOCIACION
	//Debe estar en las 2 entidades
	
}
