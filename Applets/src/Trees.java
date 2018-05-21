
public class Trees {
	
	public Trees() {
		
	}
	
	private static long factorial(long n) {
		
		if(n <= 0)
			return 0;
		else if(n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(encrypt("fWORNKLEQCPGVMMTMNCVKNGKLFCQWL", 34));
	}
	
	static String encrypt(String xorstring, int key) {
		
		char ciphertext[] = xorstring.toCharArray();
		
		String result = "";
		
		for(int i = 0; i < xorstring.length(); i++) {
			ciphertext[i] = (char) (ciphertext[i] ^ key);
		}
		
		for(char a: ciphertext) {
			result += a;
		}
		
		return result;
	}

}
