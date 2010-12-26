package com.farmerdev.patterns.delegation.solution;

public class GraphicEditor {
	private Tool tool;
	public void mouseDown() {
		tool.mouseDown();
	}

	public void setTool(Tool myTool) {
		this.tool =  myTool;
	}

}
