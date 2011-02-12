package com.farmerdev.baseDatos.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.farmerdev.baseDatos.daos.DaoPersonas;
import com.farmerdev.baseDatos.modelo.Persona;

public class DaoPersonasJdbcImpl implements DaoPersonas {
	private JdbcTemplate jdbcTemplate;

	public List<Persona> listarTodas() {
		final List<Persona> lista = new LinkedList<Persona>();
		jdbcTemplate.query("select dni,nombre,apellidos from personas", new RowCallbackHandler(){
		
			public void processRow(ResultSet rs) throws SQLException {
				lista.add(new Persona(rs.getString(1),rs.getString(2),rs.getString(3)));
				
			}
		});
		return lista;
	}

	public Persona obtenerPersonaPorId(String id) {
	
			return 
				jdbcTemplate.queryForObject("select * from personas where dni=?", new Object[]{id}, 
					new RowMapper<Persona>(){
						public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
							return new Persona(rs.getString(1),rs.getString(2),rs.getString(3));
						}
				});
	

		
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	

}
