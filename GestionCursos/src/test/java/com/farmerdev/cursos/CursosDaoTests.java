/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.farmerdev.cursos;

import static org.junit.Assert.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.farmerdev.cursos.beans.Curso;
import com.farmerdev.cursos.daos.CursosDao;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CursosDaoTests {
	private static final long ID = 1;

	private static final long ID_BORRADO = 3;

	private int NUMERO_CURSOS = 3;
	
	@Autowired
	private CursosDao cursosDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void obtencion_todos_los_cursos(){
		//TODO A–adir el nœmero de cursos que queramos probar
		
		
		List<Curso> listado = cursosDao.obtenerTodos();
		
		
		assertNotNull(listado);
		assertEquals(listado.size(),NUMERO_CURSOS);
		
		//TODO Eliminar todo lo a–adido.
			
	}
	
	@Test
	public void obtener_curso_por_identificador(){
		
		Curso curso = cursosDao.obtenerCursoPorID(ID);
		
		assertNotNull(curso);
		assertEquals(curso.getId(),ID);
		assertNotNull(curso.getTitulo());		
	}
	
	@Test
	public void borrar_curso_por_identificador(){
		insertarCurso();
		
		cursosDao.borrarPorID(ID_BORRADO);
		
		
		int numCurso = numeroDeCursoPorId(ID_BORRADO);	
		
		assertEquals(numCurso,0);
		
	}
	
	@Test
	public void insertar_curso(){
		Curso cursoAInsertar = new Curso("Titulo","Descripcion");
		cursosDao.insertar(cursoAInsertar);
		
		int numCurso = numeroDeCursoPorId(cursoAInsertar.getId());
		
		assertEquals(numCurso,1);
	}


	private void insertarCurso() {
		jdbcTemplate.update("INSERT INTO cursos (titulo,descripcion) values(?,?)", new Object[]{"Otro Titulo","Otra Descripci—n"});
		
	}

	private int numeroDeCursoPorId(long idBorrado) {
		
		return jdbcTemplate.queryForInt("select count(*) from cursos where id = ?", new Object[]{idBorrado});
			
	}
	
}
