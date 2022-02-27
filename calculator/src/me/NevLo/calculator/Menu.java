package me.NevLo.calculator;
import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
	private static ArrayList<String> choices = new ArrayList<String>();
	static Scanner in;
	
	
	public Menu(final String file) {
	    in = new Scanner(file);
		
		while(in.hasNextLine()) {
			choices.add(in.nextLine());
		}
		
	}
	public static boolean run() {
	    printChoices();
	    in = new Scanner(System.in);		
		String choice = "";
	    if(in.hasNextLine()) {
			choice = in.nextLine().toLowerCase();
	    }else {
	    	in.next();
	    }
	    if(choice.length() > 1) {
			System.out.println("Please enter only one character");
		}  else {
			switch(choice) {
			case "a":
				Operations.add();
				break;
			case "s":
				Operations.sub();
				break;	
			case "m":
				Operations.mult();
				break;
			case "d":
				Operations.div();
				break;
			case "q": 
				System.out.println("Thank you for calculating responsibly");
				return false;
			
			}
			
			choice = "";
		}
	    
		
		return true;
	}
	public static void printChoices() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n\n");
		
		for(int i = 0; i < choices.size(); i++) {
			System.out.println(" -" + i + ": " + choices.get(i) + "\n");
		}		
		System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
	}
	
	
}
