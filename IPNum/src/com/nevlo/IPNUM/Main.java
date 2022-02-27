package com.nevlo.IPNUM;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		DynamicNumber n = new DynamicNumber("413.3551351384135435843513818435135738453468768798765487387384687435846873546876874354365432185454867543245643").push();
		System.out.println(n);
		
		ArrayList<Integer> size = n.getSize();
		for(int i = 0; i < size.size(); i++) {
			System.out.println(size.get(i));
		}
		
		
		
		long num = Integer.MAX_VALUE;
		num *= 2;
		System.out.println(num);
		
		
		
		

	}
}
