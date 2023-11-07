package com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;

import com.educacionit.dao.ProductoDao;
import com.educacionit.dao.exceptions.DuplicatedException;
import com.educacionit.dao.exceptions.GenericException;
import com.educacionit.dao.jdbc.AdministradorDeConexiones;
import com.educacionit.domain.Producto;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class ProductoDaoImpl implements ProductoDao {

	@Override
	public Producto create(Producto producto) throws GenericException, DuplicatedException {
	
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		/* String sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) "
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"',"
						+ "'"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"')"; */
		
		String sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) "
				+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setString(3, producto.getCodigo());
			statement.setLong(4, producto.getTipoProducto());
			
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				Long pk = resultSet.getLong(1);
				producto.setId(pk);
			} else {
				throw new GenericException("No se pudo obtener la PK", null);
			}
			
			statement.close();
			
			return producto;
			
		} catch (SQLException e) {
			if( e instanceof SQLIntegrityConstraintViolationException ) {
				throw new DuplicatedException("Clave duplicada, no se ha registrado el producto", e);
			}
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión, verifique la DB", e1);
			}
		}
	
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
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE id = '"+id+"'";
		
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			Producto producto = null;
			
			if( resultSet.next() ) { // Si tengo registro?
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
			
			return producto;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto por id", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
	}

	@Override
	public Producto getByCodigo(String codigo) throws GenericException {
	
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE codigo = '"+codigo+"'";
		
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			Producto producto = null;
			
			if( resultSet.next() ) { // Si tengo registro?
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
			
			return producto;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto por código", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
	}

	@Override
	public Producto update(Producto producto) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto deleteById(Long id) throws GenericException {
		
		Producto producto = this.getById(id);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();

		if(producto == null) {
			throw new GenericException("No existe producto id:" + id, null);
		}
		
		String sql = "DELETE FROM productos WHERE ID = ?";
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted != 1) {
				throw new Exception("No se ha podido eliminar el producto id:" + id);
			}
			
		} catch (Exception e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
		return producto;
		
	}

	@Override
	public Producto deleteByCodigo(String codigo) throws GenericException {
		
		Producto producto = this.getByCodigo(codigo);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();

		if(producto == null) {
			throw new GenericException("No existe producto codigo:" + codigo, null);
		}
		
		String sql = "DELETE FROM productos WHERE codigo = ?";
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, codigo);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted != 1) {
				throw new Exception("No se ha podido eliminar el producto codigo:" + codigo);
			}
			
		} catch (Exception e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
		return producto;
	}

	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {

		Collection <Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE upper(titulo) like '%"+titulo+"%'";
		
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
			throw new GenericException("No se ha podido obtener ningún registro con el título", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
		
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
