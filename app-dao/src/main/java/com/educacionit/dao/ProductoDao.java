package com.educacionit.dao;

import java.util.Collection;

import com.educacionit.domain.Producto;

public interface ProductoDao {

	public Producto create(Producto producto);
	public Collection<Producto> findAll();
	public Producto getById(Long id);
	public Producto getByCodigo(String codigo);
	public Producto update(Producto producto);
	public Producto deleteById(Long id);
	public Producto deleteByCodigo(String codigo);
	public Collection<Producto> findAllByTitulo(String titulo);
	
	
}
