package project;
import collection.MyVector;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import collection.MySort;
public class PhoneNumberWordBox {
	MyVector wordList;
	MyVector numberList;
	public PhoneNumberWordBox() {
		wordList = new MyVector();
		numberList = new MyVector();
		long time = System.currentTimeMillis();
		Scanner list;
		File file = new File("WordList.txt");
		try {
			list = new Scanner(file);
			generateList(list);
			System.out.println(wordList.size());
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");	
		}
		//Put numbers before each of the words.
		//I need to test if there are words that are greater than 7;
		preFixNumbers();
		splitList();
		quickSort(numberList, wordList, 0, numberList.size() - 1);
		System.out.println(wordList.elementAt(0) + " " + wordList.elementAt(wordList.size() - 2) + " " + wordList.elementAt(wordList.size() - 1));
		System.out.println(numberList.elementAt(0) + " " + numberList.elementAt(numberList.size() - 2) + " " + numberList.elementAt(numberList.size() - 1));
		System.out.println(numberList.size());
		System.out.println(isSorted(numberList));

		//Quickly check the sort to make sure it's working	
		long end = System.currentTimeMillis();
		System.out.println((end - time) + " Milliseconds");
		//From here on out, the list splits and sorts properly after inputting my minor hack.
		
	}
	private void checkCount() {
		int count = 0;
		for (int i = 0; i < wordList.size(); i++) {
			String temp = (String)wordList.elementAt(i);
		}	
		System.out.println("Number of larger than 7 words " + count);
		
	
	}
	private void splitList() {
		for (int i = 0; i < wordList.size(); i++) {
			String temp = (String)wordList.elementAt(i);
			//if (i <= 2) System.out.println(temp);
			numberList.append(Integer.parseInt(temp.substring(0, temp.length() / 2)));
			wordList.replace(i, temp.substring(temp.length() / 2));
		}	
	}
	public PhoneNumberWordBox(String word) {
		//tests the object w/ a regular word for testing purposes
		System.out.println(getNumbersForString(word));	
	}
	private void generateList(Scanner sc) {
		int leftIn = 0;
		int total = 0;
		int leftOut = 0; 
		while (sc.hasNextLine()) {
			String temp = sc.nextLine();
			total++;
			if (temp.length() <= 7) {
				leftIn++;
				wordList.append(temp);	
			}
			
		}	
		
		//The above part is being super stupid so I need to write something that will really clear it out
		//
		//testing purposes
	}
	private String getNumbersForString(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
		       	char c = Character.toUpperCase(str.charAt(i));	
			//Hard coding ftw
			if (c >= 65 && c <= 67) {
				temp = temp + 2;			
			}
			else if (c >= 68 && c <= 70) {
				temp = temp + 3;	
			}
			else if (c >= 71 && c <= 73) {
				temp = temp + 4;	
			}
		       	else if (c >= 74 && c <= 76) {
				temp = temp + 5;	
			}
			else if (c >= 77 && c <= 79) {
				temp = temp + 6;	
			}
			else if (c >= 80 && c <= 83) {
				temp = temp + 7;	
			}
			else if (c >= 84 && c <= 86) {
				temp = temp + 8;	
			} else if (c >= 87 && c <= 90) {
				temp = temp + 9;	
			}
			else {
				temp = "Something went wrong";	
			}
			
		}
		return temp;
	}
	private void preFixNumbers() {
		int moreThanSeven = 0;
		int lessThanSeven = 0;
		for (int i = 0; i < wordList.size(); i++) {
			//I can cast it here, because I know everything will be a string
			String temp = getNumbersForString((String)wordList.elementAt(i));
			String secondTemp = (String)wordList.elementAt(i);
			secondTemp = temp + secondTemp;
			if (temp.length() > 7) moreThanSeven++;
			else lessThanSeven++;
			wordList.replace(i, secondTemp);
		}	
	
	}
	private boolean isSorted(MyVector vec) {
	
		for (int i = 0; i < vec.size() - 1; i++) {
			if (((Comparable<Object>)vec.elementAt(i)).compareTo(vec.elementAt(i + 1)) > 0) return false; 	
		}	
		return true;
	}
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
	/** This is a custom quickSort that uniquely sorts the first vector, and the second vector will follow along but will not be sorted
	 * @param vec the vector target
	 * @param secondVec the vector that will follow the target vector
	 * @param start the start of the left cursor
	 * @param end the start of the right cursor. This needs to be len + 1
	 */
	private void quickSort(MyVector vec, MyVector secondVec, int start, int end) {
		//This is some garbage and I need to refactor later
		if (start < end) {
			int partition = partition(vec, secondVec, start, end);
			quickSort(vec, secondVec, start, partition - 1);
			quickSort(vec, secondVec, partition + 1, end);
		}
	
	}
	/** This is also unique and ripped from MySort and is capable of making the second vector move with the first in unison
	 * @param vec the vector that is the target
	 * @param secondVec the vector that will follow the target vector
	 * @param low the right cursor
	 * @param high the eft cursor
	 * @return the point at which the the list should be partitioned
	 */
	private int partition(MyVector vec, MyVector secondVec, int low, int high) {
		int mid = (low + high + 1) / 2;
		if (compare(vec.elementAt(mid), vec.elementAt(low)) == -1) {
			swap(secondVec, low, mid);	
			swap(vec, low, mid);	
		}
		if (compare(vec.elementAt(high), vec.elementAt(low)) == -1) {
			swap(secondVec, low, high);	
			swap(vec, low, high);	
		}
		if(compare(vec.elementAt(mid), vec.elementAt(high)) == -1) {
			swap(secondVec, mid, high);	
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
				swap(secondVec, lowCursor, high);	
				return lowCursor;
			}
			swap(vec, lowCursor, highCursor);
		}

	}
	/**
	 * Swaps two objects in the given vector and indexes
	 * @param vec the vector that the swap will be performed on
	 * @param first the first position
	 * @param second the second position that will be switch
	 */
	private void swap(MyVector vec, int first, int second) {
		Object temp = vec.elementAt(first);
		vec.replace(first, vec.elementAt(second));
		vec.replace(second, temp);	
	}
	/** Used for comparing non prim objects
	 * @param target the piece that will be compared and the decider for the output
	 * @param otherThing the piece that target will be compared to
	 * @return -1, 0, 1 if target is less than, equal or greater than otherThing
	 */	
	private int compare(Object target, Object otherThing) {
		return ((Comparable<Object>)target).compareTo(otherThing);
	}
	
}
