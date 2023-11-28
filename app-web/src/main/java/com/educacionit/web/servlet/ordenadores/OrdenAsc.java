package com.educacionit.web.servlet.ordenadores;

import java.util.Comparator;

import com.educacionit.domain.Producto;

public class OrdenAsc implements Comparator<Producto>{
	@Override
	public int compare(Producto o1, Producto o2) {
		return o1.getPrecio().compareTo(o2.getPrecio());
	}
}
