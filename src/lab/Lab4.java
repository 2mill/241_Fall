package lab;

public class Lab4 {
	public static void test(String[] args) {
		System.out.println(isPalindrome("racecar"));
	}
	public static boolean isPalindrome(String str) {
		System.out.println(str.length());
		if (str.length() == 1) return true;
		char left = Character.toLowerCase(str.charAt(0));
		char right = Character.toLowerCase(str.charAt(0));
		if (left == right) isPalindrome(str.substring(1, str.length() - 1));
		return false;


		
	}
}
