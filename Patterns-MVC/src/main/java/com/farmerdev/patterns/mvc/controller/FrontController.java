package com.farmerdev.patterns.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmerdev.patterns.mvc.actions.core.Action;
/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties actions;
	private String view;
	
       

    public FrontController() {
        
    }
    
    @Override
    public void init() throws ServletException {
    	try {
    		loadActionsFile();
		
    	
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private void loadActionsFile() throws IOException, FileNotFoundException {
		String fileName = ClassLoader.getSystemResource("actions.properties").getFile();
		actions = new Properties();
		actions.load(new FileInputStream(fileName));
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String action = getCurrentAction(request);	
		
		this.view = executeAction(action);
		
	}
	

	private String executeAction(String action) throws ClassNotFoundException {
		Class clazz =  Class.forName(action);
		return null;
	}

	private String getCurrentAction(HttpServletRequest request) {
		String url 				= request.getRequestURI();
		String urlAction 		= getActionFromUrl(url);
		String currentAction 	= actions.getProperty(urlAction+".action");
		
		return currentAction;
	}
	
	private String getActionFromUrl(String url) {
		int lastSlashPosition = url.lastIndexOf("/");
		int lastDotPosition   = url.lastIndexOf(".");
		String subString = url.substring(lastSlashPosition+1,lastDotPosition);
		return subString;
	}


	public String getAction(String property) {
			return this.actions.getProperty(property);
	}

	public String getView() {
		return view;
	}



}
