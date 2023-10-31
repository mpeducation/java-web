package com.educacionit.dao;

import com.educacionit.dao.exceptions.GenericException;
import com.educacionit.domain.Usuario;

public interface UsuarioDao {

	public Usuario getUsuarioByName(String usuario) throws GenericException;

}
