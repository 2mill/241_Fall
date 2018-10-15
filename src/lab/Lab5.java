package lab;
import collection.MySort;
import java.util.Arrays;


public class Lab5 {
	public static void test() {
		int[] tenVals = new int[10];
		
		for (int i = 0; i < tenVals.length; i++) {
			tenVals[i] = (int)(Math.random() * 10);			
		}
		System.out.println(Arrays.toString(tenVals));
		MySort.mergeSort(tenVals);
		System.out.println(tenVals);
	}

}
