package project;
import java.util.Scanner;
import collection.MyBinaryTree;
import collection.MyExpressionTree;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Project4 {
	public static void run() {
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new File("../COSC241_P4_Input.txt"));	
		} catch (FileNotFoundException e) {
			System.out.println("input file not found");	
		}		
		File file = new File("../COSC241_P4_Output_ydorn0.txt");
		try {
			file.createNewFile();	
		} catch (IOException e) {
			System.out.println("Caught an IOException");	
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);	
		} catch (FileNotFoundException e){
			System.out.println("Printwriter could not find the output file");	
		}
		while (inputFile.hasNextLine()) {
			String holder = inputFile.nextLine();
			if (!holder.isEmpty()) continue;		
			System.out.println("Original Infix: " + holder);
			MyExpressionTree tree = new MyExpressionTree(holder);	
			System.out.print("Preorder traversal: ");
			tree.preorder();
			System.out.print("Inorder traversal: ");
			tree.inorder();
			System.out.print("Postorder traversal: ");
			tree.postorder();
			System.out.println("Evaluate Result: " + tree.evaluateTree());
		}

			
	}
}
