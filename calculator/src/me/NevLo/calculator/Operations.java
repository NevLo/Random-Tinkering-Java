package me.NevLo.calculator;
import java.util.Scanner;

public class Operations {
	static Scanner in = new Scanner(System.in);
	
	
	public static void add() {
		int a = getNum("first");
		int b = getNum("second");
		System.out.println(a + " + " + b + " = " + (a + b));
	}
	public static void sub() {
		int a = getNum("first");
		int b = getNum("second");
		System.out.println(a + " - " + b + " = " + (a - b));
	}
	public static void mult() {
		int a = getNum("first");
		int b = getNum("second");
		System.out.println(a + " * " + b + " = " + (a * b));
	}
	public static void div() {
		int a = getNum("first");
		int b = getNum("second");
		System.out.println(a + " / " + b + " = " + (a / b));
	}
	private static int getNum(String s) {
		System.out.println("Please enter the " + s + " number: ");
		if(in.hasNextInt()) {
			return in.nextInt();
		}
		return getNum(s);
	}
}
