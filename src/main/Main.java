package main;
import collection.MySort;
import collection.MyVector;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		MyVector vec = new MyVector();
		Random r = new Random(10);
		for (int i = 0; i < 10; i++) {
			vec.append(r.nextInt());	
		}
		System.out.println(vec);
		System.out.println("Post Sort");
		MySort.quickSort(vec);	
		System.out.println(vec);
		
	}
}
