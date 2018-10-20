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
	
	/**
	 * Performs an insertion sort on the given vector
	 * @param vec The vector that the insertion sort will be done on.
	 */
	public static void insertionSort(MyVector vec) {
		for (int i = 1; i < vec.size(); i++) {
			Object key = vec.elementAt(i);	
			int j = i -1;
			while (j >= 0 && compare(vec.elementAt(j), key) == 1) {
				vec.replace(j + 1, vec.elementAt(j));
				j--;	
			}
			vec.replace(j + 1, key);
		
		}
	}
	//Using arrays to practice the merge sort and then implement Vector
	
	/**
	 * Performs a Merge Sort on the given Object array
	 * @param arr The array that will be sorted
	 */
	public static void mergeSort(Object[] arr) {
		if (arr.length > 1) {
			Object[] left = Arrays.copyOfRange(arr, 0 , arr.length / 2);
			Object[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
			mergeSort(left);
			mergeSort(right);
			merge(arr , left, right);
		}

	}
	/**
	 * The merging of the arrays
	 * @param arr The array that will be sorted
	 * @param left the split left of the array
	 * @param right the split to the right of the array
	 */
	private static void merge(Object[] arr, Object[] left, Object[] right) {
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (rightIndex >= right.length || (leftIndex < left.length && compare(left[leftIndex], right[rightIndex]) <= 0)){
				arr[i] = left[leftIndex];	
				leftIndex++;
			}	
			else {
				arr[i] = right[rightIndex];
				rightIndex++;	
			}
		}

	}
	/**
	 * Performs Merge Sort on a Vector
	 * @param vec the vector that will be given back sorted.
	 */
	public static void mergeSort(MyVector vec) {
		//extract the arr and punch it into my other sorting algorithm
		Object[] arr = new Object[vec.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = vec.elementAt(i);	
		}
		mergeSort(arr);
		vec.clear();
		for (int i = 0; i < arr.length; i++) {
			vec.append(arr[i]);	
		}
	
	}	
	//useless and needs to be redone
	//garbage
	private static void mergeSort(MyVector vec, int lowest, int upper) {
		//base case
		if (lowest == upper) {
			return;		
		}  else {
		
			int mid = (lowest + upper) / 2;
			mergeSort(vec, lowest, mid);	
			mergeSort(vec, mid + 1, upper);
			//Now I know that it is split up perfectly. Now I need to be able to merge it
			merge(vec, lowest, mid + 1, upper);
		}
	}
	//garbage aswell and needs to redone
	//garbage, do not use
	private static void merge(MyVector vec, int lowCursor, int lowBound, int topBound) {
		int tempLow = lowCursor;
		MyVector tempVec = new MyVector();
		int highCursor = lowBound;
		int total = topBound - lowCursor + 1;
		topBound++;
		while (lowCursor < lowBound && highCursor < topBound) {
			if (((Comparable<Object>)vec.elementAt(lowCursor)).compareTo(vec.elementAt(highCursor)) < 1) {
				tempVec.append(vec.elementAt(lowCursor));
				lowCursor++;
				
			} else {
				tempVec.append(vec.elementAt(highCursor));
				highCursor++;
			}
		}

		while (highCursor < topBound) {
			tempVec.append(vec.elementAt(highCursor));
			highCursor++;		
		}
		while (lowCursor < lowBound) {
			tempVec.append(vec.elementAt(lowCursor));
			lowCursor++;	
		}
		for (int i = 0; i < total; i++) {
			vec.replace(i + tempLow, tempVec.elementAt(i));	
		}
		

	
	}
	/** Performs A Quick Sort on the given vector
	 * @param vec the Vector that will be sorted
	 */
	public static void quickSort(MyVector vec) {
		quickSort(vec, 0, vec.size() - 1);		
	}
	/** The actual heart of the quick sort
	 * @param vec the vector target
	 * @param start the start of the left cursor
	 * @param end the start of the right cursor. This needs to be len + 1
	 */
	private static void quickSort(MyVector vec, int start, int end) {
		//This is some garbage and I need to refactor later
		if (start < end) {
			int partition = partition(vec, start, end);
			quickSort(vec, start, partition - 1);
			quickSort(vec, partition + 1, end);
		}
	
	}
	/** Swaps and finds the correct point of partition for the function
	 * @param vec the vector that is the target
	 * @param low the right cursor
	 * @param high the eft cursor
	 * @return the point at which the the list should be partitioned
	 */
	private static int partition(MyVector vec, int low, int high) {
		int mid = (low + high + 1) / 2;
		if (compare(vec.elementAt(mid), vec.elementAt(low)) == -1) {
			swap(vec, low, mid);	
		}
		if (compare(vec.elementAt(high), vec.elementAt(low)) == -1) {
			swap(vec, low, high);	
		}
		if(compare(vec.elementAt(mid), vec.elementAt(high)) == -1) {
			swap(vec, mid, high);	
		}
		//everything from this point works
		int highCursor = high - 1;
		int lowCursor = low;
		Object pivot = vec.elementAt(high);
		while (true) {
			while (lowCursor<= highCursor&& (compare(pivot, vec.elementAt(lowCursor)) > -1)) {
				lowCursor++;	
			}
			while (highCursor>= lowCursor && (compare(pivot, vec.elementAt(highCursor)) < 1)) {
				highCursor--;	
			}
			if (lowCursor > highCursor) {
				swap(vec, lowCursor, high);	
				return lowCursor;
			}
			swap(vec, lowCursor, highCursor);
		}

	}
	/** Performs a shell sort on the given vector
	 * @param vec the Vector that will be sorted
	 */
	public static void shellSort(MyVector vec) {
		int length = vec.size();
		for (int gap = length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < length; i++) { 
				Object temp = vec.elementAt(i);
				int j;
				for (j = i; j >= gap && compare(vec.elementAt(j - gap), vec.elementAt(j)) == 1; j -= gap) {
					swap(vec, j, j - gap);
				}
				vec.replace(j, temp);
			}
		}
			
	}
	/** Used for comparing non prim objects
	 * @param target the piece that will be compared and the decider for the output
	 * @param otherThing the piece that target will be compared to
	 * @return -1, 0, 1 if target is less than, equal or greater than otherThing
	 */	
	private static int compare(Object target, Object otherThing) {
		return ((Comparable<Object>)target).compareTo(otherThing);
	}
	/**
	 * Swaps two objects in the given vector and indexes
	 * @param vec the vector that the swap will be performed on
	 * @param first the first position
	 * @param second the second position that will be switch
	 */
	private static void swap(MyVector vec, int first, int second) {
		Object temp = vec.elementAt(first);
		vec.replace(first, vec.elementAt(second));
		vec.replace(second, temp);	
	}
}
