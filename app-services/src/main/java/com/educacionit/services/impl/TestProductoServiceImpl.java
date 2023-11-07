package com.educacionit.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import com.educacionit.domain.Producto;
import com.educacionit.services.exceptions.ServiceException;

public class TestProductoServiceImpl {

	public static void main(String[] args) {
		
		ProductoServiceImpl p = new ProductoServiceImpl();
		
		try {
			Collection<Producto> productos = p.findAll();
			
			for (Producto producto : productos) {
				System.out.println(producto);
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
