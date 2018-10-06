package collection;
public class MySearch {
	/**
	 * Searches a sorted list sequentially for the right item
	 * @param vec the vector that will be searched
	 * @param target the target that will be compared to
	 * @return the index of the find
	 */
	public static int linearSearchSorted(MyVector vec, Comparable target) {
		for (int i = 0; i < vec.size(); i++) {
			if (target.compareTo(vec.elementAt(i)) == 0) return i;	
		}
		return 0;
	}
	/**
	 * Searches a sorted list binarily and returns the index of the found item
	 * @param vec the vector that will be searched
	 * @param target the target that will be compared to
	 * @return the index of the found value
	 */
	public static int binarySearch(MyVector vec, Comparable target) {
		int min = 0;
		int max = vec.size();
		int middle;
		while (true) {
			int length = max - min;
			middle = length / 2 + min;
			int val = target.compareTo(vec.elementAt(middle));
			if (val == 0) {
				return middle;		
			} else if (val > 0) {
				min = middle;	
			} else if (val < 0) {
				max = middle;		
			}	
		}
	}
}
