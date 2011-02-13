package com.farmerdev.cursos.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.farmerdev.cursos.beans.Curso;
import com.farmerdev.cursos.daos.CursosDao;

public class CursosDaoJdbcSpringImpl implements CursosDao {
	private JdbcTemplate jdbcTemplate;
	
	public List<Curso> obtenerTodos() {
		final List<Curso> listado = new LinkedList<Curso>();
		
		jdbcTemplate.query("select * from cursos",new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				listado.add(new Curso(rs.getLong("id"),rs.getString("titulo"),rs.getString("descripcion")));
				
			}
		});
	
		return listado;
	}

	

	public Curso obtenerCursoPorID(long id) {
		
		return jdbcTemplate.queryForObject("select * from cursos where id = ?", new Object[]{id}, new RowMapper<Curso>() {

			public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Curso(rs.getLong("id"),rs.getString("titulo"),rs.getString("descripcion"));
			}
		});
	}
	
	
	public void borrarPorID(long idBorrado) {
		jdbcTemplate.update("delete from cursos where id=?", new Object[]{idBorrado});
		
	}
	
	public void insertar(Curso cursoAInsertar) {
				
	}
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	
	

}
