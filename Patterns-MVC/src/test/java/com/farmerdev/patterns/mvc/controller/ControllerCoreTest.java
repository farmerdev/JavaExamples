package com.farmerdev.patterns.mvc.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;



public class ControllerCoreTest {
	@Test
	public void extractActionFromUrl(){
 
		final String myURL = "http://localhost:8080/MyApp/login.do";
    	
    	ControllerCore controllerCore = new ControllerCore();
    	String result = controllerCore.getAction(myURL);
    	
    	assertEquals("login",result);
    	
	}

}
