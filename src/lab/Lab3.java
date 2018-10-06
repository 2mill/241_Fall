package lab;
import collection.MyVector;
import collection.MySort;
import collection.MySearch;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class Lab3 {
	public static void test() {
		MyVector numVec = new MyVector();
		Random rand = new Random(System.nanoTime());
		for (int i = 0; i < 900; i++) {
			int num = rand.nextInt(899) + 101;		
			numVec.append(num);
		}
		MySort.bubbleSort(numVec);
		System.out.println(numVec);
		Scanner sc = new Scanner(System.in);
		int input = 0;
		boolean pass = true;
		do {

			System.out.println("Please give me a valid integer to find :");	
			String temp = sc.nextLine();
			try {
				input = Integer.parseInt(temp);	
			} catch (InputMismatchException e) {
				pass = false;
			}
		} while (!pass);
		System.out.println(MySearch.linearSearchSorted(numVec, input));
		numVec.removeRange(50,550);
		numVec.reverse();
		MySort.selectionSort(numVec);
		System.out.println(numVec);
		input = 0;
		do {

			System.out.println("Please give me a valid integer to find :");	
			String temp = sc.nextLine();
			try {
				input = Integer.parseInt(temp);	
			} catch (InputMismatchException e) {
				pass = false;
			}
		} while (!pass);
		System.out.println(MySearch.binarySearch(numVec, input));
		
	}
}
