package collection;
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
}
