import javax.swing.JFrame;

public abstract class Parent extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private static Thread start;
	
	public Parent() {
		setup();
		
		start = new Thread(this, "Start");
		start.start();
	}	
	
	
	public abstract void draw();
	public abstract void setup();
	
	public void size(int width, int height) {
		
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void run() {
		while(true) {
			
			draw();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
	}
}
