package com.farmerdev.patterns.mvc.actions.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	public Action() {
		// TODO Auto-generated constructor stub
	}
	public abstract void execute();
	
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
	
	
}
