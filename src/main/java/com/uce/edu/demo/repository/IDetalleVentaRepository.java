package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ReporteVentas;
import com.uce.edu.demo.repository.modelo.Venta;

public interface IDetalleVentaRepository {

	public List<Venta> reporteFecha(LocalDateTime fecha);
	public List<ReporteVentas> reporte(String categoria, Integer cantidad);

	
}
