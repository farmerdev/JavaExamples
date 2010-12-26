package com.farmerdev.patterns.delegation.initial;

public class GraphicEditor {
	
	
	public static final int SELECTING = 1;
	public static final int CREATING_RECTANGLE = 2;
	private int tool;

	public void mouseDown() {
		switch(getTool()){
			case SELECTING:
				System.out.println("Mouse Downing with Selecting Tool");
				break;

			case CREATING_RECTANGLE:
				System.out.println("Mouse Downing with Rectangle Tool");

			

		}
		
	}

	public int getTool() {
		return this.tool;
	}

	public void setTool(int tool) {
		this.tool = tool;
	}



}
