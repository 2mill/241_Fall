package lab;
import collection.DLList;
import collection.MyDeque;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class Lab8 {
	public static void test() {
		MyDeque simpleDeque = new MyDeque();			
		Scanner sc = null;
		try {
			sc = new Scanner(new File("../COSC241_L8_Input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");	
		}
		File outputFile = new File("../COSC241_L8_Output_ydorn0.txt");
		try {
			if (!outputFile.exists()) 
				outputFile.createNewFile();
		} catch (IOException e) {
			System.out.println("File creation did not work for some reason");	
			
		} 
		PrintWriter output = null;
		try {
			output = new PrintWriter(outputFile);	
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");	
		}
		while  (sc.hasNextLine()) {

			String temp = sc.nextLine();	
			temp = temp.trim();
			System.out.println(temp.length());
			for (int i = 0; i < temp.length(); i++) {
				simpleDeque.append(temp.charAt(i));	
			}
			boolean end = true;
			while (simpleDeque.peekFirst() != null && simpleDeque.peekLast() != null) {
				System.out.println(simpleDeque.toString());
				if (simpleDeque.popFirst() != simpleDeque.popLast()) {
					System.out.println("failed here");
					end = false;
					break;
				}
				end = true;
			}
			if (simpleDeque.peekFirst() == simpleDeque.peekLast()) {
				end = true;	
			}
			output.println(end);

		}
		output.close();
	}
}

	
