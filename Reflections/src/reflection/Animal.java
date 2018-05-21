package reflection;

public class Animal {
	
	public void walk() {
		System.out.println("Just took 2 steps");
	}
	
	public void talk() {
		System.out.println("Talking....");
	}
	
	public void run() {
		System.out.println("Running");
	}
	
	public void sleep() {
		System.out.println("Sleeping");
	}
	
	public static void main(String[] args) {
		
		new Reflections();
	}

}
