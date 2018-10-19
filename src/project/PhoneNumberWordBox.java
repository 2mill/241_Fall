package project;
import collection.MyVector;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import collection.MySort;
public class PhoneNumberWordBox {
	MyVector wordList = new MyVector();
	MyVector numberList = new MyVector();
	public PhoneNumberWordBox() {
		long time = System.currentTimeMillis();
		Scanner list;
		File file = new File("WordList.txt");
		try {
			list = new Scanner(file);
			generateList(list);
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");	
		}
		//Put numbers before each of the words.
		preFixNumbers();
		MySort.quickSort(wordList);
		System.out.println(wordList.elementAt(0) + " " + wordList.elementAt(1) + " " + wordList.elementAt(wordList.size() - 1));
		//Quickly check the sort to make sure it's working	
		wordList.reverse();
		System.out.println(wordList.elementAt(0) + " " + wordList.elementAt(wordList.size() - 2) + " " + wordList.elementAt(wordList.size() - 1));
		long end = System.currentTimeMillis();
		System.out.println((end - time) + " Milliseconds");
		//Everything from here works like I want it to.
		//Now I need to split the list
		
	}
	public PhoneNumberWordBox(String word) {
		//tests the object w/ a regular word for testing purposes
		System.out.println(getNumbersForString(word));	
	}
	private void generateList(Scanner sc) {
		int count = 0;
		while (sc.hasNextLine()) {
			count++;
			wordList.append(sc.nextLine());	
		}	
		//testing purposes
		if (count == wordList.size()) System.out.println("List Generation success");
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
		for (int i = 0; i < wordList.size(); i++) {
			//I can cast it here, because I know everything will be a string
			String temp = getNumbersForString((String)wordList.elementAt(i));
			String secondTemp = (String)wordList.elementAt(i);
			secondTemp = temp + secondTemp;
			wordList.replace(i, secondTemp);
		}	
	
	}
	private boolean isSorted(MyVector vec) {
	
		for (int i = 0; i < vec.size() - 1; i++) {
			if (((Comparable<Object>)vec.elementAt(i)).compareTo(vec.elementAt(i + 1)) > 0) return false; 	
		}	
		return true;
	}
	
}
