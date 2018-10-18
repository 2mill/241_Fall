package lab;
import collection.MySort;
import java.util.Arrays;
import collection.MyVector;


public class Lab5 {
	public static void test() {
		int number = (int)(Math.random() * 99) + 1;
		MyVector temp = new MyVector();
		temp.append(6);
		temp.append(3);
		temp.append(9);
		System.out.println(temp);
		MySort.selectionSort(temp);
		System.out.println(temp);
	}
	public static void vecRandomize(MyVector vec, int numbers) {
		for (int i = 0; i < 10; i++) {
			vec.append((int)(Math.random() * 100));	
		}
			
	}
	public static boolean isSorted(MyVector vec) {
		int first = (int)(vec.elementAt(0));	
		for (int i = 0; i < vec.size() - 1; i++) {
			if (!(first <= (int)(vec.elementAt(i + 1)))) return false;	
			else first = (int)vec.elementAt(i+1);
		}
		return true;
	}


}
