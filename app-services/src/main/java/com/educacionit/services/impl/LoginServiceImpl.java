package com.educacionit.services.impl;

import com.educacionit.dao.UsuarioDao;
import com.educacionit.dao.exceptions.GenericException;
import com.educacionit.dao.impl.UsuarioDaoImpl;
import com.educacionit.domain.Usuario;
import com.educacionit.services.LoginService;
import com.educacionit.services.exceptions.ServiceException;

public class LoginServiceImpl implements LoginService {
	
	private UsuarioDao usuarioDao;
	
	public LoginServiceImpl() {
		this.usuarioDao = new UsuarioDaoImpl();
	}

	@Override
	public Usuario getUserByUserName(String usuario) throws ServiceException {
		try {
			return this.usuarioDao.getUsuarioByName(usuario);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
