import java.awt.Graphics;

import javax.swing.JApplet;

public class FractalTree extends JApplet {
	

	private static final long serialVersionUID = 1L;

	public void start() {
		setSize(500, 500);
		setName("Fractal Tree");
	}
	
	public void update() {
		
		getGraphics().drawLine(getWidth()/2, lengthConversion(10), getWidth()/2, 500);
		repaint();
		
		
		
	}
	
	private int lengthConversion(int length) {
		return length * 10^500; 
	}
	
	public void paint(Graphics graphics)
	{
		//graphics.setPaintMode();
		
		graphics.drawLine(getWidth()/2, lengthConversion(10), getWidth()/2, 500);
		
	}
}
