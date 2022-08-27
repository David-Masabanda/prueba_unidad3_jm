package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.ReporteVentas;
import com.uce.edu.demo.repository.modelo.Venta;

@Repository
@Transactional
public class DetalleRepositoryImpl implements IDetalleVentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Venta> reporteFecha(LocalDateTime fecha) {
		TypedQuery<Venta> myQuery=this.entityManager.createQuery(
				"SELECT d FROM DetalleVenta d JOIN RIGHT d.venta v WHERE v.fecha= : datoFecha", 
				Venta.class);
		myQuery.setParameter("datoFecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public List<ReporteVentas> reporte(String categoria, Integer cantidad) {
		TypedQuery<ReporteVentas> myQuery=this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.ReporteVentas(p.codigoBarras, p.nombre, d.cantidad, d.precioUnitario, d.subtotal) "
				+ "FROM DetalleVenta d JOIN RIGHT d.producto p WHERE p.categoria= : datoCategoria AND d.cantidad= :datoCantidad", 
				ReporteVentas.class);
		myQuery.setParameter("datoCategoria", categoria);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

}
