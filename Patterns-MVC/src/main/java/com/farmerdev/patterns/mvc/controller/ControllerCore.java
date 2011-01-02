package com.farmerdev.patterns.mvc.controller;

import javax.servlet.http.HttpServletRequest;



public class ControllerCore {

	public String getAction(String url) {
		int lastSlashPosition = url.lastIndexOf("/");
		int lastDotPosition   = url.lastIndexOf(".");
		String subString = url.substring(lastSlashPosition+1,lastDotPosition);
		return subString;
	}

	
}
