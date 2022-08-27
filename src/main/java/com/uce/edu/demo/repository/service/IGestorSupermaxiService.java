package com.uce.edu.demo.repository.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ListaProductos;
import com.uce.edu.demo.repository.modelo.Producto;

public interface IGestorSupermaxiService {

	public void insertarProducto(Producto p);
	
	public void realizarVenta(List<ListaProductos> productos, String cedula, String numero);

	public void consultarStock(String codigo);
	
	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);
	
}
