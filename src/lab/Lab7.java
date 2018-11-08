package lab;
import java.util.Scanner;
import collection.MyStack;
import collection.MyQueue;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class Lab7 {

	public static void test() {
		Scanner sc = new Scanner(System.in);
		MyStack stack = new MyStack();
		MyQueue queue = new MyQueue();
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < 60; i++) {
			int num = r.nextInt();	
			stack.push(num);
			queue.insertBack(num);
		}
		for (int i = 0; i < 30; i++) {
			stack.pop();
			queue.removeFront();	
		}
		File f = new File("COSC241_L7_Output_ydorn0.txt");	
		try {
			if (!f.exists()) f.createNewFile();
		} catch (IOException e) {
			System.out.println("Something went wrong");	
		}
		System.out.println(stack.toString());
		System.out.println(queue.toString());
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("COSC241_L7_Output_ydorn0.txt");
		} catch (FileNotFoundException e) {
		
		}	
		while (!stack.isEmpty()) {
			writer.println(stack.pop().toString());	
		}
		writer.println("append");
		while(!queue.isEmpty()) {
			writer.println(queue.removeFront().toString());	
		}
		writer.close();
	}

}
