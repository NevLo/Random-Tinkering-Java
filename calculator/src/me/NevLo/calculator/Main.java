package me.NevLo.calculator;

import java.util.Scanner;

public class Main {
	
	public static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println("Hello, Welcome to my calculator application");
		
			while(Menu.run()) {
				
			}
			
			
			
			
			
			/* 
		 
			boolean checkFlag = false;
			while(!checkFlag) {
		
				String choice = "";
				if(input.hasNextLine()) {
				 choice = input.nextLine().toLowerCase();
				}else {
					choice = input.next();
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
						checkFlag = true;
						run = false;
						System.out.println("Thank you for calculating responsibly");
						break;
					}
					checkFlag = true;
					choice = "";
				}
			}
			*/
		//}
	}
	
}

