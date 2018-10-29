package project;
import collection.MyVector;
import java.util.Scanner;
public class StringTest {

	public static void main(String[] args) {
		PhoneNumberWordBox instance = new PhoneNumberWordBox();
		//Check the number	
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while (!str.equalsIgnoreCase("cancel")) {
			System.out.println("Please insert a telephone number w/ 7 digits and numbers ranging between 2-9.");	
			System.out.println("If you would like to cancel the program, please type in cancel");
			str = sc.nextLine();
			String temp = "";
			//clear dashes
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != '-') {
					temp = temp + str.charAt(i);	
				}	
			}
			str = temp;
			if (checkNumber(str)) {
				long startTime = System.currentTimeMillis();
				MyVector list = instance.getStringForNumber(str);
				int size = list.size();
				if (size > 0) {
					System.out.println(size + " words were found");	
					System.out.println(list);
				}
				else {
					System.out.println("No words were found");	
				}
				long endTime= System.currentTimeMillis();
				System.out.println("TTC : " + (endTime-startTime) + " milliseconds");
			} else {
				System.out.println("This is not a valid number");	
			}	
			System.out.println(str);
			
		} 
		
		
		

	}
	public static boolean checkNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			int val = number.charAt(i);
			if (!Character.isDigit(number.charAt(i)) && val < '2') {
				return false;	
			}
		}	
		return true;
	}
}
