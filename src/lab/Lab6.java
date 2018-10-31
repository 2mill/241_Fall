package lab;
import collection.SLList;
public class Lab6 {

	public static void test() {

	
		SLList test = new SLList(); 	
		System.out.println(test);
		test.append(5);
		test.append(6);
		test.remove(5);
		test.insert(7);
		System.out.println(test);
		test.clear();
		System.out.println(test.isEmpty());
	}
}
