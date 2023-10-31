package com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		
		String url = "jdbc:mysql://localhost:32768/java";
		
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericException("No se ha podido obtener una conexión", e);
		}	
		
	}
	
}
