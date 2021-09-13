
public class Main {
	public static void main(String[] args) {
		//lets design a LFSR that XORS the last 2 bits
		//
		// 	     ______	
		//		 V    ^
		//       1 0 0 1 >>
		//		 1 1 0 0	
		//
		int original = 0b1001;
		System.out.println("0000".substring(Integer.toBinaryString(original).length()) + Integer.toBinaryString(original));
		do{
			int newbit = (original ^ (original >> 1)) & 0b0001;
			original = (newbit << 3) | (original >> 1);
			//System.out.println("0000".substring(Integer.toBinaryString(original).length()) + Integer.toBinaryString(original));
			System.out.println(String.format("%4s", Integer.toBinaryString(original)).replace(" ", "0"));
		}while (original != 0b1001);
		
		
	}
}
