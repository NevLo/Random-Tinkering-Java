package me.cpilley.xortesting;

public class Main {
	public static void main(String [] args) {
		boolean t1 = true^false;
		boolean t2 = false^false;
		boolean t3 = true^true;
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}
}
