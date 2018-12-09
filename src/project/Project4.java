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
			System.out.println(holder.length());
			if (holder.length() == 0) {
				continue;	
			}
			writer.println("Original Infix: " + holder);
			MyExpressionTree tree = new MyExpressionTree(holder);	
			if (tree.isEmpty()) {
				writer.println("Invalid Expression"); 
				writer.println();
				continue;
			}
			writer.print("Preorder traversal: ");
			writer.println(tree.preOrder());
			writer.print("Inorder traversal: ");
			writer.println(tree.inOrder());
			writer.print("Postorder traversal: ");
			writer.println(tree.postOrder());
			writer.println("Evaluate Result: " + tree.evaluateTree());
			writer.println();
		}
		writer.close();

			
	}
}
