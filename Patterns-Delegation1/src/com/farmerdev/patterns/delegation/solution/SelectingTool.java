package com.farmerdev.patterns.delegation.solution;

public class SelectingTool implements Tool {

	@Override
	public void mouseDown() {
		System.out.println("Mouse Downing with Selecting Tool");

	}

}
