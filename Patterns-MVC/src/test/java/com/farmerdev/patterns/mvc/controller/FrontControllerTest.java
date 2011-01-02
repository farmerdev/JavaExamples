package com.farmerdev.patterns.mvc.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.farmerdev.patterns.mvc.actions.LoginAction;


public class FrontControllerTest {
	private FrontController frontController;
	@Before
	public void setUp(){
		frontController = new FrontController();
	}
	
	@Test
	public void servletInitialization() throws ServletException{
		
		
		frontController.init();
		
		assertNotNull(frontController.getAction("login.action"));
		assertEquals("com.farmerdev.patterns.mvc.actions.LoginAction",frontController.getAction("login.action"));
	}
//	@Test
//	public void getCurrentAction() throws ServletException{
//		MockHttpServletRequest request = new MockHttpServletRequest("GET","/login.do"); 
//		frontController.init();
//		String currentAction = frontController.getCurrentAction(request);
//		
//		assertEquals("com.farmerdev.patterns.mvc.actions.LoginAction",currentAction);
//		
//	}
	@Test
	public void getRequestToView() throws ServletException, IOException{
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/login.do"); 
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		frontController.doGet(request,response);
		assertEquals("login.jsp",frontController.getView());
		
	}

}
