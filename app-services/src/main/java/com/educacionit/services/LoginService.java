package com.educacionit.services;

import com.educacionit.domain.Usuario;
import com.educacionit.services.exceptions.ServiceException;

public interface LoginService {

	Usuario getUserByUserName(String usuario) throws ServiceException;
}

