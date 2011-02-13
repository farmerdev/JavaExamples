package com.farmerdev.cursos.daos;

import java.util.List;

import com.farmerdev.cursos.beans.Curso;

public interface CursosDao {

	List<Curso> obtenerTodos();

	Curso obtenerCursoPorID(long id);

	void borrarPorID(long idBorrado);

	void insertar(Curso cursoAInsertar);

}
