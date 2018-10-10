package lab;
import java.util.Scanner;

public class Lab4 {
	public static void test(String[] args) {
		System.out.println("Welcome to the Palindrome word evalutation program.");
		System.out.println("All that needs to be done is inserting a word and the program will tell you if it's a palindrome or not");
		System.out.println("Please follow this format : Type in the answer, followed by the <ENTER> key for the best accuracy");
		String input = new String();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Please enter your word (Enter no to cancel program): ");
			input = sc.nextLine();
			if (input.equalsIgnoreCase("no")) break;
			input = isPalindrome(input) ? "This is a palindrome" : "This is not a palindrome";
			System.out.println(input);
		}

		
		

		

	}
	public static boolean isPalindrome(String str) {
		if (str.length() < 2) {
			return true;	
		} else {
		
			char first = Character.toLowerCase(str.charAt(0));
			char last = Character.toLowerCase(str.charAt(str.length() - 1));
			if (first == last) {
				return isPalindrome(str.substring(1, str.length() - 1));	
			} else {
				return false;	
			}	

		}


		
	}
}
