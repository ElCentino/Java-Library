package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files {
	
	public Files() {
		
		File file = new File("C:\\users\\Chelsea\\Desktop\\loremipsum.txt");
		
		if(!file.exists()) {
			
			try {
				file.createNewFile();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		
		//writeFile(file, "This is my file mofos if u wanna take control of it do so but ill find ya and "
				//+ "kill ya\nYh i aint joking am a total badass madafakers");
		
		readFile(file);
		
		
	}
	
	private void readFile(File file) {
		
		Scanner r = null;
		
		try {
			r = new Scanner(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		while(r.hasNext()) {
			
			System.out.println(r.nextLine());
		}
	}
	
	private void writeFile(File file, String text) {
		
		PrintWriter printer = null;
		
		try {
			printer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		printer.println(text);
		
		printer.flush();
		printer.close();
		
	}
	
	public static void main(String[] args) {
		
		char r = 'g';
		
		System.out.println(r - 'a');
		
	}

}
