package com.nevlo.IPNUM;

import java.util.ArrayList;


public class DynamicNumber {

	// 2D array list to store our number, this will make it so that we can
	// store a number this size of 2^32 * 2^32 digits
	private ArrayList<ArrayList<Character>> number = new ArrayList<ArrayList<Character>>();
	
	
	
	// Origin is stored in an 1D array of integers. 
	// if the origin is not in the first array if number, a -1 is stored in that slot.
	// an example in a 5x5 array:
	//
	//	[ 1 ][ 3 ][ 9 ][ 5 ][ 0 ] 
	//  [ 5 ][ 8 ][ 4 ][ 0 ][ 0 ] 
	//  [ 4 ][ 6 ][ . ][ 0 ][ 0 ] = number
	//  [ 9 ][ 1 ][ 6 ][ 0 ][ 0 ] 
	//  [ 1 ][ 2 ][ 2 ][ 0 ][ 0 ] 
	
	//  [-1 ][-1 ][ 2 ][-1 ][-1 ] = origin
	
	// 				^ 
	// so the origin is in at 2,2. if this was a full size DynamicNumber, 
	// the origin would be at (2*Integer.MAX_VALUE + 2)
	
	private ArrayList<Integer> origin = new ArrayList<Integer>();

	// Makes a new Dynamic number and adds an arrayList in index 0,
	// giving a starting length 2^31-1

	public DynamicNumber() {
		number.add(new ArrayList<Character>());
		origin.add(0);
	}

	// makes a new DynamicNumber from a double value;
	public DynamicNumber(double value) {
		number.add(new ArrayList<Character>());
		Double d = new Double(value);
		String ds = d.toString();
		for (int i = 0; i < ds.length(); i++) {
			number.get(0).add(ds.charAt(i));
		}
		origin.add(ds.indexOf('.'));
	}

	// makes a new DynamicNumber from a string value;
	public DynamicNumber(String value) {
		number.add(new ArrayList<Character>());
		for (int i = 0; i < value.length(); i++) {
			number.get(0).add(value.charAt(i));
		}
		origin.add(value.indexOf('.'));
	}

	// makes a new Dynamic Number from another DynamicNumber
	public DynamicNumber(DynamicNumber d) {
		number = d.number;
	}

	@Override
	public String toString() {
		String s = "";
		for (ArrayList<Character> a : number) {
			for (Character chr : a) {
				s += chr;
			}
		}
		for (int i = getOrigin() - 3; i > 0; i -= 3) {
			s = s.substring(0, i) + ',' + s.substring(i, s.length());
		}
		return s;
	}
	public DynamicNumber push(){
		number.add(new ArrayList<Character>());
		return this;
	}
	public ArrayList<Integer> getSize() {
		ArrayList<Integer> sizeOF = new ArrayList<Integer>();
		for(int i = 0; i < number.size(); i++) {
			if(number.get(i).size() == Integer.MAX_VALUE) {
				sizeOF.add(-1);
				continue;
			}else {
				sizeOF.add(number.get(i).size());
			}
		}
		return sizeOF;
	}
	public int getOrigin() {
		int o = 0;
		if (origin.get(0) == -1) {
			for (int i = 0; i < origin.size(); i++) {

			}
		} else {
			o = origin.get(0);
		}
		return o;
	}
}
