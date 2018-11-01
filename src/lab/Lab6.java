package lab;
import collection.SLList;
import collection.SortedSLList;
import java.util.Scanner;
public class Lab6 {

	public static void test() {
		SLList simpleList = new SLList();
		for (int i = 1; i <= 30; i++) {
			simpleList.append(i*i);	
		}
		System.out.println(simpleList);
		simpleList.remove(25);
		simpleList.remove(36);
		simpleList.remove(64);
		simpleList.remove(100);
		simpleList.remove(400);
		System.out.println(simpleList);
		SortedSLList sortedList = new SortedSLList();
		for (int i = 1; i <= 30; i++) {
			 sortedList.append(i*i);	
		}
		simpleList.remove(1);
		simpleList.remove(25);
		simpleList.remove(36);
		simpleList.remove(64);
		simpleList.remove(144);
		simpleList.remove(400);
		simpleList.remove(900);
		System.out.println(sortedList);
		simpleList.insert(1);
		simpleList.insert(64);
		simpleList.insert(400);
		simpleList.insert(900);
		System.out.println(sortedList);
	}
}
