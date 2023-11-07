package com.educacionit.dao;

import java.util.Collection;

import com.educacionit.dao.exceptions.DuplicatedException;
import com.educacionit.dao.exceptions.GenericException;
import com.educacionit.domain.Producto;

public interface ProductoDao {

	public Producto create(Producto producto) throws GenericException, DuplicatedException;
	public Collection<Producto> findAll() throws GenericException;
	public Producto getById(Long id) throws GenericException;
	public Producto getByCodigo(String codigo) throws GenericException;
	public Producto update(Producto producto) throws GenericException;
	public Producto deleteById(Long id) throws GenericException;
	public Producto deleteByCodigo(String codigo) throws GenericException;
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException;
	
	
}
