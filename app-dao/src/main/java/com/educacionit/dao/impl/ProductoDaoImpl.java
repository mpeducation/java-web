package com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.educacionit.dao.ProductoDao;
import com.educacionit.dao.exceptions.GenericException;
import com.educacionit.dao.jdbc.AdministradorDeConexiones;
import com.educacionit.domain.Producto;

public class ProductoDaoImpl implements ProductoDao {

	@Override
	public Producto create(Producto producto) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Producto> findAll() throws GenericException {
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Producto producto = productoFromResultSet(resultSet);
				
				productos.add(producto);
			}
			
			statement.close();

			return productos;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha logrado acceder a la DB", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión, verifique la DB", e1);
			}
		}
	}

	@Override
	public Producto getById(Long id) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getByCodigo(String codigo) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto update(Producto producto) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto deleteById(Long id) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto deleteByCodigo(String codigo) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Producto productoFromResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1); // ID
		String titulo = resultSet.getString(2);
		Float precio = resultSet.getFloat(3);
		String codigo = resultSet.getString(4);
		Long tipoProducto = resultSet.getLong(5);
		
		producto = new Producto(id, titulo, precio, codigo, tipoProducto);
		return producto;
	}

}
