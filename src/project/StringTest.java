package project;
import collection.MyVector;
public class StringTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		PhoneNumberWordBox test = new PhoneNumberWordBox();
		MyVector list = test.getStringForNumber("22");
		System.out.println(list);
		test.getNumberForIndexInput();
		
		
		long endTime= System.currentTimeMillis();
		System.out.println("TTC : " + (endTime-startTime) + " milliseconds");

	}
}
