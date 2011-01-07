package com.farmerdev.patterns.mvc.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



public class FrontControllerTest {
	private FrontController frontController;
	@Before
	public void setUp() throws ServletException{
		frontController = new FrontController();
		frontController.init();
	}
	
	@Test
	public void servletInitialization(){
				
		assertNotNull(frontController.getAction("login.action"));
		assertEquals("com.farmerdev.patterns.mvc.actions.LoginAction",frontController.getAction("login.action"));
	}

	@Test
	public void getRequestWithCorrectView() throws ServletException, IOException{
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/login.do"); 
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		frontController.doGet(request,response);
		assertEquals("login.jsp",frontController.getView());
		
	}
	
	@Test
	public void postRequestWithCorrectView() throws ServletException, IOException{
		MockHttpServletRequest request = new MockHttpServletRequest("POST","/login.do"); 
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		frontController.doGet(request,response);
		assertEquals("login.jsp",frontController.getView());
		
	}


}
