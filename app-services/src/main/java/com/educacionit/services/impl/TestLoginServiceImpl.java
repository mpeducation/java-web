package com.educacionit.services.impl;

import com.educacionit.domain.Usuario;
import com.educacionit.services.exceptions.ServiceException;

public class TestLoginServiceImpl {

	public static void main(String[] args) {
		
		LoginServiceImpl ls = new LoginServiceImpl();
		
		try {
			Usuario u1 = ls.getUserByUserName("mprincipe");
			System.out.println(u1);
			Usuario u2 = ls.getUserByUserName("mnefle");
			System.out.println(u2);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
