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
	private String urlAction;
	private String view;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	
       

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
		this.httpServletRequest = request;
		this.httpServletResponse = response;
		String action = getCurrentAction(request);	
		
		try {
			executeAction(action);
			this.view = actions.getProperty(this.urlAction+".nextView");
			redirectTo(this.view);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void redirectTo(String nextView) throws ServletException, IOException {
		this.httpServletRequest.getRequestDispatcher(nextView).forward(this.httpServletRequest,this.httpServletResponse);
	}
	

	private void executeAction(String action) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		@SuppressWarnings("rawtypes")
		Class clazz =  Class.forName(action);
		Action actionToExecute = (Action) clazz.newInstance();
		actionToExecute.setHttpServletRequest(this.httpServletRequest);
		actionToExecute.setHttpServletResponse(this.httpServletResponse);
		
		actionToExecute.execute();
		
	}
	
	private String getCurrentAction(HttpServletRequest request) {
		String url 				= request.getRequestURI();
		this.urlAction 			= getActionFromUrl(url);
		String currentAction 	= actions.getProperty(this.urlAction+".action");
		
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
