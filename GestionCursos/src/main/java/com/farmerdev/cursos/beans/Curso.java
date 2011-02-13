package com.farmerdev.cursos.beans;

public class Curso {
	private long id;
	private String titulo;
	private String descripcion;

	public Curso(long id, String titulo, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		
	}

	public Curso(String titulo, String descripcion) {
		this(-1,titulo,descripcion);
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	@Override
	public String toString() {
		
		return "id="+this.id+",titulo="+this.titulo+",descripcion="+this.descripcion;
	}
	

}
