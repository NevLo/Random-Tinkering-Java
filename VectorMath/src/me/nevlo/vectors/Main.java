package me.nevlo.vectors;

public class Main {

	public static void main(String[] args) {
		Vector b = new Vector(1, 1, 1);
		Vector c = new Vector(1, 1, 1);
		b.add(c);
		b.printVector(System.out);
	}

}
