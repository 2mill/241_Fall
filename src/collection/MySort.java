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
	public static void insertionSort(MyVector vec) {
		for (int i = 1; i < vec.size(); i++) {
			Object comparator = vec.elementAt(i);	
			for (int j = 0; j <= i; j++) {
				if (compare(comparator, vec.elementAt(j)) == -1) {
					//push everything and insert;	
					vec.replace(i, vec.elementAt(i - 1));
				} else {
					vec.replace(i, comparator);	
				}	
			}
		}	
	}
	//Using arrays to practice the merge sort and then implement Vector
	public static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] left = Arrays.copyOfRange(arr, 0 , arr.length / 2);
			int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
			System.out.println("Splitting " + Arrays.toString(arr) + " into " + Arrays.toString(left) + " " + Arrays.toString(right));
			mergeSort(left);
			mergeSort(right);
			merge(arr , left, right);
		}

	}
	//merging here now
	//a lot of this code was taken from the book while trying to learn how this works
	//A lot of this involves making partitions. I could use this as a cop out and just extract the array from
	//the vector, but let's not and actually try to properly implement it like at the bottom
	public static void merge(int[] arr, int[] left, int[] right) {
		System.out.println("Merge Sorting the following now");
		System.out.println(Arrays.toString(left) + " with " + Arrays.toString(right));
		//This is so gay sometimes
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
				arr[i] = left[leftIndex];	
				leftIndex++;
			}	
			else {
				arr[i] = right[rightIndex];
				rightIndex++;	
			}
			System.out.println("Array looks like this right now" + Arrays.toString(arr));
		}

	}
	//Now we are going to implement merge sort w/ Vector. The hard way.
	public static void mergeSort(MyVector vec) {
		mergeSort(vec, 0, vec.size() - 1);
	
	}	
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
	public static void quickSort(MyVector vec, int start, int end) {
		//This is some garbage and I need to refactor later
		if (start + 1 != end) {
			int partition = partition(vec, start, end - 1);
			quickSort(vec, start, partition + 1);
			quickSort(vec, partition + 1, end);
		}
	
	}
	private static int partition(MyVector vec, int low, int high) {
		int mid = (low + high) / 2;
		if (compare(vec.elementAt(mid), vec.elementAt(low)) == -1) {
			swap(vec, low, mid);	
		}
		if (compare(vec.elementAt(high), vec.elementAt(low)) == -1) {
			swap(vec, low, high);	
		}
		if (compare(vec.elementAt(high), vec.elementAt(mid)) == -1) {
			swap(vec, mid, high);	
		}
		//Median of three works till here
		int pivot = high;
		//have the right pivot point and the correct starts and stops
		while (true) {
			do {
				low++;
			} while (compare(vec.elementAt(pivot), vec.elementAt(low)) == 1); //Increment until finding the end
			do {
				high--;	
			} while (compare(vec.elementAt(pivot), vec.elementAt(high)) == -1); //Increment until finding the lower
			if (high <= low) {
				return high;//return the point where things change.	
			}
			//otherwise swap
			swap(vec, low, high);

		
		}

	}
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
	//now comes insertion sort
	
	private static int compare(Object target, Object otherThing) {
		return ((Comparable<Object>)target).compareTo(otherThing);
	}
	private static void swap(MyVector vec, int first, int second) {
		Object temp = vec.elementAt(first);
		vec.replace(first, vec.elementAt(second));
		vec.replace(second, temp);	
	}


	private static void printVectorRange(MyVector vec, int start, int end) {
	
		System.out.print("[ ");	
		for (int i = start; i < end; i++) {
			System.out.print(vec.elementAt(i));
			if (i != end - 1) {
				System.out.print(", ");	
			}	
		}
		System.out.println("]");
		return;
	}



			









}
