package com.educacionit.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.services.ProductoService;
import com.educacionit.services.impl.ProductoServiceImpl;
import com.educacionit.web.enums.ViewEnums;
import com.educacionit.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	
	protected ProductoService ps = new ProductoServiceImpl();
	
	// métodos
	public static void addAtribute(HttpServletRequest request, ViewKeyEnums key, Object value) {
		request.setAttribute(key.name(), value);
	}
	
	public static void addAtribute(HttpServletRequest request, ViewEnums key, Object value) {
		request.setAttribute(key.name(), value);
	}
	
	public void redirect(ViewEnums target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}
	
}
