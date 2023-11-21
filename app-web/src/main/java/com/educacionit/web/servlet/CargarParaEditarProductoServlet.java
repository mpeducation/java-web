package com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.domain.Producto;
import com.educacionit.web.enums.ViewEnums;
import com.educacionit.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class CargarParaEditarProductoServlet
 */
public class CargarParaEditarProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		ViewEnums target = ViewEnums.EDITAR_PRODUCTO;
		
		try {
			Producto aux = super.ps.getById(Long.parseLong(id));
			addAtribute(request, ViewKeyEnums.PRODUCTO_EDITAR, aux);
		} catch (Exception e) {
			addAtribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
			target = ViewEnums.LISTADO_GENERAL;
			
			//recargo la lista de productos
			Collection<Producto> productos;
			try {
				productos = super.ps.findAll();
			} catch (Exception e2) {
				productos = new ArrayList<Producto>(); 
			}
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);
		}
		
		redirect(target, request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
