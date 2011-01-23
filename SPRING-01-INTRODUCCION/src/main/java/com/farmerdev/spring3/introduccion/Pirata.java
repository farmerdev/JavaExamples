package com.farmerdev.spring3.introduccion;

public class Pirata {
	private String nombre;
	private MapaDelTesoro mapa;

	

	public Pirata() {
		// TODO Auto-generated constructor stub
	}
	
	public Pirata(MapaDelTesoro mapa) {
		this.mapa = mapa;
	}

	public void setMapa(MapaDelTesoro mapa) {
		this.mapa = mapa;
		
		
	}

	public MapaDelTesoro getMapa() {
		return this.mapa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 

}
