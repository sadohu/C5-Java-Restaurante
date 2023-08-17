package com.web.restaurante.controller;


import java.io.File;
import java.io.OutputStream;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.restaurante.business.impl.ProductoServiceImpl;
import com.web.restaurante.model.Producto;

import com.web.restaurante.utils.Libreria;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	@Autowired
	private ProductoServiceImpl servicioProducto;
	
	@RequestMapping("/producto")
	public void inicio(HttpServletResponse response) {
		try {
			//obtener todos los productos
			List<Producto> data=servicioProducto.listaProducto();
			//acceder al reporte "reporte_medicamentos.jrxml"
			File file=ResourceUtils.getFile("classpath:reporte1.jrxml");
			//origen de datos convertir data a tipo JRBeanCollectionDataSource
			JRBeanCollectionDataSource info=new JRBeanCollectionDataSource(data);
			//invocar al método generarReporte
			JasperPrint print=Libreria.generarReporte(file, info);
			//salida en el navegador en formato pdf
			response.setContentType("application/pdf");
			//salida de flujo
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
} //fin de ReporteController
