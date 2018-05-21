
public class Time implements Runnable {
	
	public static final float deltaTime = 0.01f;
	
	private Thread timer;
	
	private boolean running;
	private int hour;
	private int minute;
	private float second;
	
	public Time() {
		
		timer = new Thread(this, "Timer");
		timer.start();
		
		running = true;
	}
	
	@Override 
	public void run() {
		
		while(running) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public float getSecond() {
		return second;
	}
	
	private void update() {
		
		second += 1 * deltaTime;
		second = Math.round(second);
	}
}
