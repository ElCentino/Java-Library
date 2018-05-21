import java.util.ArrayList;

public class Coding {
	
	public static int total = 25;
	public static Coding[] langs = new Coding[total];
	public static int instances = 0;
	
	public static ArrayList<String> lists = new ArrayList<String>();
	public static String lang = "";
	
	public Coding(String language) {
		
		lists.add(language);
		
		lang = language;
	}
	
	public static void addCoding(String language) {
		
		if(instances >= total) {
			System.out.println("Cant add more classes");
			return;
		}		
		
		langs[++Coding.instances] = new Coding(language);
	}
	
	public static void main(String[] args) {
		
		addCoding("Java");
		addCoding("C++");
		addCoding("Perl");
		
		System.out.println(print());
		
		System.out.println("Total classes are : " + instances);
		
		System.out.println(Coding.langs[0]);

	}

	private static String print() {
		
		String langs = "";
		
		for(String x: lists) {
			
			langs += x + " : ";
		}
		
		return "Languages are : "  + langs;
	}
	
	public String toString() {
		
		return lang;
	}

}
