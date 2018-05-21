


public class Lambda {
	
	interface Data {
		int math(int a, int b);
	}

	Data add = (a, b) -> {
		return a + b;
	};
	
	static int operate(int a, int b, Data data) {
		return data.math(a, b);
	}
	
	public static void main(String[] args) {
		
		
	}
}
