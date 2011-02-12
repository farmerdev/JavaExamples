package com.farmerdev.baseDatos.servicios;

import java.util.List;

import com.farmerdev.baseDatos.modelo.Persona;

public interface ServicioPersonas {

	List<Persona> listarTodas();

	Persona obtenerPersonaPorId(String id);

}
