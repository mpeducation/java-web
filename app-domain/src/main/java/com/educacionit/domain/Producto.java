package com.educacionit.domain;

public class Producto {

	private Long id;
	private String titulo;
	private Float precio;
	private String codigo;
	private Long tipoProducto;
	
	// db -> java
	public Producto(Long id, String titulo, Float precio, String codigo, Long tipoProducto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}
	
	// sin id: java -> db
	public Producto(String titulo, Float precio, String codigo, Long tipoProducto) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}

	public Producto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	@Override
	public String toString() {
		return "Producto => " + id + " , " + titulo + " , " + precio + " , " + codigo
				+ " , " + tipoProducto;
	}
	
	
	
	
	
	
	
	
	
	
	
}
