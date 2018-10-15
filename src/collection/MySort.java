package collection;
import java.util.Arrays;
public class MySort {

	/**
	 * Uses bubblesort on the given vector
	 * @param vec the vector that will be sorted
	 */
	public static void bubbleSort(MyVector vec) {
		boolean swapped; 
		do {
			swapped = false;
			for (int i = 0; i < vec.size() - 1; i++) {
				if ((int)vec.elementAt(i) > (int) vec.elementAt(i+1))  {
					swapped = true;	
					Object temp = vec.elementAt(i);
					vec.replace(i, vec.elementAt(i+1));
					vec.replace(i+1, temp);
				}	

			}	
		} while (swapped);
	}
	/**
	 * Uses selection sort to sort the list
	 * @param vec the vector that will be sorted
	 */
	public static void selectionSort(MyVector vec) {
		for (int i = 0; i < vec.size(); i++) {
			int smallestIndex = i;
			for (int j = i; j < vec.size(); j++) {
				if ((int)vec.elementAt(j) < (int)vec.elementAt(smallestIndex)) smallestIndex = j;	
			}
			//swap
			Object temp = vec.elementAt(i);
			vec.replace(i, vec.elementAt(smallestIndex));
			vec.replace(smallestIndex, temp);
		}		
	}
	//Using arrays to practice the merge sort and then implement Vector
	public static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] left = Arrays.copyOfRange(arr, 0 , arr.length / 2);
			int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
			System.out.println("I got the following " + Arrays.toString(left));
			System.out.println("and " + Arrays.toString(right));
			mergeSort(left);
			mergeSort(right);
			merge(arr , left, right);
		}

	}
	//merging here now
	//a lot of this code was taken from the book while trying to learn how this works
	public static void merge(int[] arr, int[] left, int[] right) {
		int leftIndex = 0; 
		int rightIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex]))	{
				arr[i] = left[leftIndex];	
			} else {
				arr[i] = right[rightIndex];	
			}

		}	
	}
			
}
