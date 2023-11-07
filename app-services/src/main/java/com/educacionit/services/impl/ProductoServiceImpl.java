package com.educacionit.services.impl;

import java.util.Collection;

import com.educacionit.dao.ProductoDao;
import com.educacionit.dao.exceptions.GenericException;
import com.educacionit.dao.impl.ProductoDaoImpl;
import com.educacionit.domain.Producto;
import com.educacionit.services.ProductoService;
import com.educacionit.services.exceptions.ServiceException;

public class ProductoServiceImpl implements ProductoService{
	
	private ProductoDao productoDao;
	
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDaoImpl();
	}

	@Override
	public Collection<Producto> findAll() throws ServiceException {
		
		try {
			return this.productoDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public Producto getById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto nuevoProducto(Producto producto) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Producto> buscarProductos(String clave) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto eliminarProducto(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarProducto(Producto producto) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerPorCodigo(String codigo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
