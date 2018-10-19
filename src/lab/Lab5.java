package lab;
import collection.MySort;
import java.util.Arrays;
import collection.MyVector;
import java.util.Random;
import java.util.Date;


public class Lab5 {
	public static void test() {

		//bubbleSort
		MyVector target = new MyVector();
		long startTime;
		long endTime;
		makeRandom(target);
		startTime = System.currentTimeMillis();
		MySort.bubbleSort(target);
		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort TTC : " +(endTime - startTime) + " milliseconds");
		printExactElements(target);
		makeRandom(target);
		startTime = System.currentTimeMillis();
		MySort.selectionSort(target);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Sort TTC : " +(endTime - startTime) + " milliseconds");
		printExactElements(target);
		makeRandom(target);
		startTime = System.currentTimeMillis();
		MySort.mergeSort(target);
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort  TTC : " +(endTime - startTime) + " milliseconds");
		printExactElements(target);
		makeRandom(target);
		startTime = System.currentTimeMillis();
		MySort.quickSort(target);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort TTC : " +(endTime - startTime) + " milliseconds");
		printExactElements(target);
		makeRandom(target);
		startTime = System.currentTimeMillis();
		MySort.insertionSort(target);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort TTC : " +(endTime - startTime) + " milliseconds");
		printExactElements(target);
		makeRandom(target);
		startTime = System.currentTimeMillis();
		MySort.shellSort(target);
		endTime = System.currentTimeMillis();
		System.out.println("Shell Sort TTC : " +(endTime - startTime) + " milliseconds");
		printExactElements(target);
		
			

		

	}
	public static void vecRandomize(MyVector vec, int numbers) {
		for (int i = 0; i < 1; i++) {
			vec.append((int)(Math.random() * 100));	
		}
			
	}
	public static void printExactElements(MyVector vec) {
		System.out.println(vec.elementAt(0) + " " + vec.elementAt(1) + " " + vec.elementAt(2) + " " + vec.elementAt(9999) + " " + vec.elementAt(19999) + " " + vec.elementAt(29999));		
	}
	public static boolean isSorted(MyVector vec) {
		int first = (int)(vec.elementAt(0));	
		for (int i = 0; i < vec.size() - 1; i++) {
			if (!(first <= (int)(vec.elementAt(i + 1)))) return false;	
			else first = (int)vec.elementAt(i+1);
		}
		return true;
	}
	public static void runCheck(MyVector vecs[]) {
		int number = (int)(Math.random() * 99) + 1;
		int sorted = 0;
		for (int i = 0; i < number ; i++) {
			vecs[i] = new MyVector();
			vecRandomize(vecs[i], 10);
			System.out.print(i +". " + vecs[i] + " -> ");	
			MySort.insertionSort(vecs[i]);
			System.out.println(vecs[i]);
			sorted = isSorted(vecs[i]) ? sorted + 1: sorted;
		}
		System.out.println("Success rate : " + ((double)(sorted / number) * 100));
	
	}
	public static void makeRandom(MyVector vec) {
		vec.clear();
		Random r = new Random();
		r.setSeed(20181010);		
		for (int i = 0; i < 30000; i++) {
			vec.append(r.nextInt(99999));	
		}
	}


}
