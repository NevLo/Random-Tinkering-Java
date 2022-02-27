import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LetterStuff {
	static Scanner sc;
	static Scanner cons;
	static String mode;

	public static void main(String[] args) {
		File words = new File("Words.txt");
		cons = new Scanner(System.in);
		System.out.println("Would you like to start the program in (S)tring or (C)har mode?");
		while (true) {
			if (cons.nextLine().toCharArray()[0] == 'S') {
				mode = "String";

				break;
			} else if (cons.nextLine().toCharArray()[0] == 'C') {
				mode = "Char";
				break;
			} else {
				System.out.println("Please enter a correct mode.");
			}
		}
		System.out.println("Starting the program in " + mode + " mode");

		try {
			sc = new Scanner(words);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> sList = new ArrayList<String>();
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			for (int i = 0; i < s.length; i++) {
				sList.add(s[i]);
			}
		}

		System.out.println(sList.size());
		ArrayList<Character> notAllowed;
		ArrayList<Character> includedLet;
		if (mode == "Char") {
			notAllowed = getBannedLetters();
			includedLet = getIncludedLetters();
		} else {
			notAllowed = getBannedLettersAsString();
			includedLet = getIncludedLettersAsString();
		}
		outer: for (int j = sList.size() - 1; j >= 0; j--) {

			for (int i = 0; i < notAllowed.size(); i++) {
				if (sList.get(j).indexOf(notAllowed.get(i)) != -1) {
					sList.remove(j);
					continue outer;
				}
			}
			for (int i = 0; i < includedLet.size(); i++) {
				if (sList.get(j).indexOf(includedLet.get(i)) == -1) {
					sList.remove(j);
					break;
				}
			}

		}

		for (int i = sList.size() - 1; i >= 0; i--) {
			// if (sList.get(i).indexOf('I') != 1 || sList.get(i).indexOf('E') != 3 ||
			// sList.get(i).indexOf('R') != 4) {
			// sList.remove(i);
			// }

		}

		System.out.println(sList.size());
		System.out.println(sList);
	}

	public static ArrayList<Character> getBannedLetters() {
		ArrayList<Character> t = new ArrayList<Character>();
		do {
			System.out.println("Enter a char not in the word\n>>>");
			t.add(cons.nextLine().toCharArray()[0]);
			System.out.println("Would you like to enter another letter? (Y/N)\n>>>");
		} while (cons.nextLine().equals("Y"));

		return t;

	}

	public static ArrayList<Character> getIncludedLetters() {
		ArrayList<Character> t = new ArrayList<Character>();
		do {
			System.out.println("Enter a char in the word\n>>>");
			t.add(cons.nextLine().toCharArray()[0]);
			System.out.println("Would you like to enter another letter? (Y/N)\n>>>");
		} while (cons.nextLine().equals("Y"));
		return t;
	}

	public static ArrayList<Character> getBannedLettersAsString() {
		System.out.println("Enter all chars not in the word\n>>>");
		ArrayList<Character> t = new ArrayList<Character>();
		t.addAll(cons.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		return t;
	}

	public static ArrayList<Character> getIncludedLettersAsString() {
		System.out.println("Enter all chars in the word\n>>>");
		ArrayList<Character> t = new ArrayList<Character>();
		t.addAll(cons.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		return t;
	}
}
