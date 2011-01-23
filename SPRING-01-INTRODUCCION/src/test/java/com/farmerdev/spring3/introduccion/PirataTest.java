package com.farmerdev.spring3.introduccion;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PirataTest {
	private static ApplicationContext ctx = null;
	
	@BeforeClass
	public static void inicializar(){
		ctx = new ClassPathXmlApplicationContext("config.xml");
	}
	
	@Before
	public void inicializarCadaTest(){
		
	}
	
	@Test
	public void creacion_del_pirata_inyeccion_con_setter_sin_spring(){
		
		//Inicializaci—n (A)
		Pirata pirata = new Pirata();
		MapaDelTesoro mapa = new MapaDelTesoro();
		
		
		//Acto (Act)
		pirata.setMapa(mapa); //Injecci—n de dependencias por setter
		
		//Comprobaciones (A)
		assertNotNull(pirata);
		assertNotNull(pirata.getMapa());
		
	}
	
	@Test
	public void creacion_del_pirata_inyeccion_por_constructor_sin_spring(){
		//Inicializaci—n (A)
		MapaDelTesoro mapa = new MapaDelTesoro();
		Pirata pirata = new Pirata(mapa);
	
		
		//Comprobaciones (Assert)
		assertNotNull(pirata);
		assertNotNull(pirata.getMapa());
		
	}
	
	@Test
	public void creacion_del_pirata_inyeccion_con_setter_con_spring(){
		
		Pirata pirata = null;
		
		
		
		pirata = (Pirata)ctx.getBean("barbaRoja");
		
		//Comprobaciones (Assert)
		assertNotNull(pirata);
		assertNotNull(pirata.getMapa());
	
		
	}
	
	@Test
	public void creacion_del_pirata_con_nombre(){
		
		Pirata pirata = null;
				
		pirata = (Pirata)ctx.getBean("barbaAzul");
		
		
		assertNotNull(pirata);
		assertNotNull(pirata.getNombre());
	}
	
	@Test
	public void creacion_pirata_unico(){
		Pirata pirata1 = null;
		Pirata pirata2 = null;
		
		pirata1 = (Pirata)ctx.getBean("barbaAzul");
		pirata2 = (Pirata)ctx.getBean("barbaAzul");
		
		System.out.println(pirata1);
		System.out.println(pirata2);
		
		assertNotNull("Pirata Nulo",pirata1);
		assertNotNull("Pirata Nulo",pirata2);
		assertEquals("Los piratas no son iguales",pirata1,pirata2);		
		
	}
}
