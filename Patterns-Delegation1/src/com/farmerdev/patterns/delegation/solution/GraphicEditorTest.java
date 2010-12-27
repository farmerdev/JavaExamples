package com.farmerdev.patterns.delegation.solution;

import org.junit.Before;
import org.junit.Test;

/**
 * Delegation Pattern in Action. This is the solution with delegation to the IF problem
 * @author ialcazar
 *
 */
//TODO Modify test. Add Asserts --> Refactor
public class GraphicEditorTest {
	private GraphicEditor ge;
	@Before
	public void setUp(){
		ge = new GraphicEditor();
		
	}
	@Test
	public void mouseDownWithSelectingTool(){
		Tool myTool = new SelectingTool();
		ge.setTool(myTool);
		
		ge.mouseDown();
		
	}
	@Test
	public void mouseDownWithRectangleTool(){
		Tool myTool = new RectangleTool();
		ge.setTool(myTool);
		ge.mouseDown();
	}

}
