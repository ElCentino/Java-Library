import java.util.ArrayList;

class Practicing {
	
	static ArrayList<String> counts = new ArrayList<String>();
	
	public static String LongestWord(String sen) {

		// code goes here
		/*
		 * Note: In Java the return type of a function and the parameter types
		 * being passed are defined, so this return call must match the return
		 * type of the function. You are free to modify the return type.
		 */

		String[] words = sen.split(" ");

		for (int i = 0; i < words.length - 1; i++) {
			if (words[i].length() > words[i + 1].length()) {
				swap(words, i, i + 1);
			}
		}

		sen = words[words.length - 1];

		return sen;

	}

	public static int FirstFactorial(int num) {

		// code goes here
		/*
		 * Note: In Java the return type of a function and the parameter types
		 * being passed are defined, so this return call must match the return
		 * type of the function. You are free to modify the return type.
		 */

		if (num <= 0)
			return 1;
		else if (num <= 1)
			return 1;
		else
			return num * FirstFactorial(num - 1);
	}

	public static void swap(String[] word, int left, int right) {
		String temp = word[left];
		word[left] = word[right];
		word[right] = temp;
	}

	public static String LetterCapitalize(String str) {

		String[] words = str.split(" ");

		String result = "";

		for (String word : words) {

			String[] newWords = word.split("");
			String temp = newWords[0].toUpperCase();
			newWords[0] = temp;

			word = "";

			for (String newWord : newWords) {
				word += newWord;
			}

			result += word + " ";
		}

		return result;

	}

	public static void main(String[] args) {
		// keep this function call here
		QuestionsMarks("aa6???4???5??ggg5");
		System.out.println(evalAll());
	}

	public static String SimpleSymbols(String str) {

		// code goes here
		/*
		 * Note: In Java the return type of a function and the parameter types
		 * being passed are defined, so this return call must match the return
		 * type of the function. You are free to modify the return type.
		 */

		String alphabets = "abcdefghijklmnopqrstuvwxyz";

		char plus = '+';

		String[] alphas = alphabets.split("");

		boolean[] passes = new boolean[alphas.length + str.length()];

		int locator = 0;

		for (int i = 0; i < alphas.length; i++) {

			if (str.contains(alphas[i])) {

				try {

					if (str.charAt(str.indexOf(alphas[i]) + 1) == plus
							&& str.charAt(str.indexOf(alphas[i]) - 1) == plus) {

						passes[locator] = true;
						locator++;
					} else {
						passes[locator] = false;
						locator++;
					}

				} catch (StringIndexOutOfBoundsException e) {
					passes[locator] = false;
					locator++;
				}

			}
		}

		return Locator(passes, locator);

	}

	static String Locator(boolean[] passes, int index) {

		for (int i = 0; i < index; i++) {

			if (passes[i] == false) {
				return "false";
			}
		}

		return "true";
	}

	static void testing() {
		int test = 56;
	}

	public static void QuestionsMarks(String str) {

		ArrayList<Integer> lists = new ArrayList<Integer>();
		ArrayList<Integer> pos = new ArrayList<Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (Character.isDigit(str.charAt(i))) {
				lists.add(Integer.parseInt(Character.toString(str.charAt(i))));
				pos.add(i);		
			}
		}
		
		if(lists.size() != 0) {
			
			for(int i = 0; i < lists.size() - 1; i++) {
				if((lists.get(i) + lists.get(i+1) / 2) == 5) {
					counts.add(checkForMarks(str, pos.get(i), pos.get(i+1), true));
				}else if (lists.get(i) + lists.get(i+1) == 10 && (lists.get(i) + lists.get(i+1) / 2) != 5) {
					counts.add(checkForMarks(str, pos.get(i), pos.get(i+1), false));
				}
			}
			
		} else {
			return;
		}	

		return;

	}

	static String checkForMarks(String characters, int left, int right, boolean xact) {

		int markCount = 0;

		String sub = characters.substring(left+ 1, right);
		
		System.out.println(left + " " + right);
		
		System.out.println(sub);

		for (int i = 0; i < sub.length(); i++) {

			if (Character.toString(sub.charAt(i)).equals("?")) {
				markCount++;
			}
		}
		
		System.out.println("Mark Count : " + markCount);
		
		if(xact== true) {
			if (markCount == 3) {
				return "true";
			} else {
				return "false";
			}
		}

		if (markCount == 3) {
			return "true";
		} 

		return "false";
	}
	
	static String evalAll() {
		
		for(String x: counts) {
			System.out.println("dfd" + x);
		}
		
		if(counts.contains("false")) {
			return "false";
		} else if(counts.isEmpty()) {
			return "false";
		} else {
			return "true";
		}
	}
}
