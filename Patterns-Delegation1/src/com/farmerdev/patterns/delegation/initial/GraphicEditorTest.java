package com.farmerdev.patterns.delegation.initial;

import org.junit.Test;

/**
 * The original problem
 * @author ialcazar
 *
 */
public class GraphicEditorTest {
	
	@Test
	public void mouseDownWithSelectingTool(){
		GraphicEditor ge = new GraphicEditor();
		ge.setTool(GraphicEditor.SELECTING);
		
		ge.mouseDown();
		
	}
	@Test
	public void mouseDownWithRectangleTool(){
		GraphicEditor ge = new GraphicEditor();
		ge.setTool(GraphicEditor.CREATING_RECTANGLE);
		
		ge.mouseDown();
	}

}
