package com.uce.edu.demo.repository.modelo;

public class CantidadStock {

	private String codigoBarras;
	private String nombre;
	private Long stock;
	
	
	public CantidadStock(String codigoBarras, String nombre, Long stock) {
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.stock = stock;
	}
	
	//SET y GET
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "CantidadStock [codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", stock=" + stock + "]";
	}
	
	

	
	
}
