package com.web.restaurante.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
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


@Data
public class ProductoItem {
	
	private int idProducto;
	private String nomProducto;
	private String desProducto;
	private double preciouniProducto;
	private int stockProducto;
	@Lob
	private byte[] imagenProducto;
	private String estadoProducto;
	
	private CategoriaProducto categorria;
	
}
