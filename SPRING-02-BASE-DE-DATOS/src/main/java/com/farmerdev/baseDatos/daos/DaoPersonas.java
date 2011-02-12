package com.farmerdev.baseDatos.daos;

import java.util.List;

import com.farmerdev.baseDatos.modelo.Persona;

public interface DaoPersonas {

	List<Persona> listarTodas();

	Persona obtenerPersonaPorId(String id);

}
