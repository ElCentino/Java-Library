
public class STR {
	
	static void Process(String time) {
		
		int divider = time.indexOf(':');
        int minute = Integer.parseInt(time.substring(0, divider));
        int seconds = Integer.parseInt(time.substring(divider + 1, time.length()));

        System.out.println(minute + " : " + seconds);
	}
	
	public static void main(String[] args) {
		
		String sample = "12:40";
		
		Process(sample);
	}
}
