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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="tb_producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int idProducto;
	@Column(name = "nom_producto")
	private String nomProducto;
	@Column(name ="des_producto")
	private String desProducto;
	@Column(name = "preciouni_producto")
	private double preciouniProducto;
	@Column(name ="stock_producto" )
	private int stockProducto;
	@Lob
	@Column(name = "imagen_producto")
	private byte[] imagenProducto;
	@Column(name="estado_producto")
	private String estadoProducto;
	
	@ManyToOne
	@JoinColumn(name="id_categoria_producto")
	//variable ASOCIACION ENTRE TABLAS este es un Objeto de CategoriaProducto
	private CategoriaProducto cate;//Donde este nombre tipo es la ASOCIACION
	//Debe estar en las 2 entidades
	
}
