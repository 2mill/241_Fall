package lab;
import collection.MySort;
import java.util.Arrays;
import collection.MyVector;


public class Lab5 {
	public static void test() {
		int number = (int)(Math.random() * 99) + 1;
		MyVector[] vecs = new MyVector[number];
		int passes = 0;
		for (int i = 0; i < number; i++) {
			vecs[i] = new MyVector();
			vecRandomize(vecs[i], 10);	
			System.out.print(i + ". " + vecs[i] + " -> ");
			MySort.mergeSort(vecs[i]);
			System.out.println(vecs[i]);
			passes = isSorted(vecs[i]) ? passes + 1 : passes;
		}
		double rate = (double)(passes/number) * 100;
		System.out.println("Success Rate " + rate + "%");
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
