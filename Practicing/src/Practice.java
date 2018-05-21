
public class Practice extends Parent implements ITakable {
	
	private static final long serialVersionUID = 1L;

	private static Thread update;
	
	private static float value = 34;
	
	public Practice() {
		
	}
	
	public static void main(String[] args) {
		new Practice();
		new Human();
	}
	
	static float map(float source, float startingPoint, float endPoint, float min, float max) {
		
		float val = 0; 
		
		if(source <= endPoint) {
			val = (((source - startingPoint) / 100) *  (max / (endPoint/100))) + min;
		} else {
			System.out.println("Value Exceeded");
		}
		
		return val;
	}
	
	static void update() {
			
		update = new Thread("Update") {

			public void run() {
							
				while(true) {
					
					value++;
					
					float map = map(value, 0, 640, 0, 255);
					System.out.println(map);			
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}
		}; 
		
		update.start();
	}
	
	public void setup() {
		size(600, 400);
	}
	
	public void draw() {
		System.out.println("11");
	}
}