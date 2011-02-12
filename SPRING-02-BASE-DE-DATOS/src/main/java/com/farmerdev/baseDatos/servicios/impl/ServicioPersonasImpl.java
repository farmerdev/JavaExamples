package com.farmerdev.baseDatos.servicios.impl;

import java.util.List;

import com.farmerdev.baseDatos.daos.DaoPersonas;
import com.farmerdev.baseDatos.modelo.Persona;
import com.farmerdev.baseDatos.servicios.ServicioPersonas;

public class ServicioPersonasImpl implements ServicioPersonas{

	private DaoPersonas daoPersonas;

	public List<Persona> listarTodas() {
		
		return daoPersonas.listarTodas();
	}

	public Persona obtenerPersonaPorId(String id) {
		
		return daoPersonas.obtenerPersonaPorId(id);
	}
	
	
	public DaoPersonas getDaoPersonas() {
		return daoPersonas;
	}

	public void setDaoPersonas(DaoPersonas daoPersonas) {
		this.daoPersonas = daoPersonas;
	}
	
	

}
