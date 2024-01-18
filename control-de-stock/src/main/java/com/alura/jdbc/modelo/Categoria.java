package com.alura.jdbc.modelo;

public class Categoria {
	
	private String nombre;
	public Categoria(int id, String nombre) {
		this.nombre = nombre;
		
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

}
