package com.uce.edu.demo.repository.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.ListaProductos;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ReporteVentas;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class GestorSupermaxiServiceImpl implements IGestorSupermaxiService{

	private static Logger LOG =Logger.getLogger( GestorSupermaxiServiceImpl.class);
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IDetalleVentaRepository detalleVentaRepository;
	
	@Override
	public void insertarProducto(Producto p) {
		Producto producto=this.productoRepository.buscarProducto(p.getCodigoBarras());
		if(producto==null) {
			this.productoRepository.ingresarProducto(p);
		}else {
			Integer stock=producto.getStock()+p.getStock();
			p.setStock(stock);
			this.productoRepository.actualizarProducto(p);
		}
	}

	@Override
	public void realizarVenta(List<ListaProductos> productos, String cedula, String numero) {
		this.ventaService.procesarVenta(productos, cedula, numero);
	}

	@Override
	public void consultarStock(String codigo) {
		this.productoRepository.consultarStock(codigo);
	}

	@Override
	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		List<Venta> listaVentas=this.detalleVentaRepository.reporteFecha(fecha);
		List<ReporteVentas>listaReportes=new ArrayList<>();
		for(Venta reporte: listaVentas) {
			listaReportes=this.detalleVentaRepository.reporte(categoria, cantidad);
		}
		
		for(ReporteVentas reportes: listaReportes) {
			LOG.info("Reporte de Ventas:"+reportes);
		}
		

	}
	
	
	

}
