package lab;
public class Lab4 {
	public static void test(String[] args) {
		System.out.println(isPalindrome("racecar"));
	}
	public static boolean isPalindrome(String str) {
		//Placing a comment here
		char left, right;
		while (!str.isEmpty()) {
			str = str.substring(1,str.length() - 1);
		}
		return true;
	}
}
