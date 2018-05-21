import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Crap implements PropertyChangeListener {
	
	private JPanel targetpanel;
	private int red;
	private int green;
	private int blue;
	
	public Crap(JPanel pane, int r, int g, int b) {
		targetpanel = pane;
		red = r;
		green = g;
		blue = b;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		targetpanel.setBackground(new Color(red, green, blue));
		
		System.out.println("Called");
	}
}
