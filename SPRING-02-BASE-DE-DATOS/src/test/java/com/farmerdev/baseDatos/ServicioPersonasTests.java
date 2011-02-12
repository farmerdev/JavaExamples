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
package com.farmerdev.baseDatos;

import static org.junit.Assert.*;

import java.util.List;


import javax.inject.Inject;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.farmerdev.baseDatos.modelo.Persona;
import com.farmerdev.baseDatos.servicios.ServicioPersonas;

@ContextConfiguration(locations={"classpath:com/farmerdev/baseDatos/appContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ServicioPersonasTests {
	@Inject
	private JdbcTemplate jdbcTemplate;
	@Inject
	private ServicioPersonas servicioPersonas;
	
	
	@Test
	@Ignore
	public void testDataAccess() throws Exception {
		
		int rowNums = jdbcTemplate.queryForInt("select count(1) from personas");
		
		assertEquals(3, rowNums);
	
	}

	@Test
	public void listar_todas_las_personas(){
		List<Persona> listado = servicioPersonas.listarTodas();
		
		assertNotNull(listado);
		assertEquals(3,listado.size());
	}
	
	@Test
	public void obtener_persona_por_identificador(){
		Persona persona = servicioPersonas.obtenerPersonaPorId("123456k");
		
		assertNotNull(persona);
	}
}
