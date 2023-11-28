package com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.domain.Producto;
import com.educacionit.services.exceptions.ServiceException;
import com.educacionit.web.enums.ViewEnums;
import com.educacionit.web.enums.ViewKeyEnums;
import com.educacionit.web.servlet.ordenadores.OrdenAsc;
import com.educacionit.web.servlet.ordenadores.OrdenDesc;

/**
 * Servlet implementation class BuscarProductoServlet
 */
public class BuscarProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String claveBusqueda = request.getParameter(ViewKeyEnums.CLAVE_BUSQUEDA.getViewKey());
		System.out.println(claveBusqueda);
		
		if( claveBusqueda == null || claveBusqueda.trim().equals("")) {
			claveBusqueda = "";
		}
		
		Collection<Producto> productos = new ArrayList<>();
		
		try {
			productos = ps.buscarProductos(claveBusqueda);
			
			Stream<Producto> stream = productos.stream();
			
			//obtener los parametros de los filtros
			String titulo = request.getParameter("titulo");
			if(titulo != null && !"".equals(titulo.trim())) {
				stream = stream.filter(p -> p.getTitulo().contains(titulo));
			}
			
			//precio mayores o iguales
			String precio = request.getParameter("precio");
			if(precio !=null && !"".equals(precio.trim())) {
				Float precioF = Float.parseFloat(precio);
				stream = stream.filter(p -> p.getPrecio() >= precioF);
			}
			
			String tipo = request.getParameter("tipo");
			if(tipo != null && !"".equals(tipo.trim())) {
				Long tipoL = Long.parseLong(tipo);
				stream = stream.filter(p-> p.getTipoProducto().equals(tipoL));
			}
			
			//aplico todos los filtros (si hay)
			productos = stream.collect(Collectors.toList());
			
			//otenngo orden
			
			String orden = request.getParameter("orden");
			if("asc".equals(orden)) {
				Collections.sort((List)productos, new OrdenDesc());
			}else {
				Collections.sort((List)productos, new OrdenAsc());
			}
			
			Float suma = productos.stream()
				.map(p -> p.getPrecio())
				.reduce(0F, (Float x, Float y) -> x+y);
			
			addAtribute(request, ViewKeyEnums.TOTAL, suma);
		} catch (ServiceException e) {
			addAtribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
		} finally {
			addAtribute(request, ViewKeyEnums.LISTADO, productos);
		}
		
		
		//redireccion
		getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getView()).forward(request, response);
	}
}
