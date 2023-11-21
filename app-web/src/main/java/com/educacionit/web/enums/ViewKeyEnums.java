package com.educacionit.web.enums;

public enum ViewKeyEnums {
	ID_PRODUCTO("id"),
	ERROR_GENERAL("error"),
	EXITO("exito"),
	LISTADO("listado");
	
	private String viewKey;

	private ViewKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}
	
	public String getViewKey() {
		return viewKey;
	}
}
