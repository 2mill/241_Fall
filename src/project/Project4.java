package project;
import java.util.Scanner;
import collection.MyBinaryTree;
import collection.MyExpressionTree;
public class Project4 {
	public static void run() {
		Scanner sc = new Scanner(System.in);	
		MyExpressionTree tree = new MyExpressionTree();
		for (int i = 0; i < 5; i++) {
			tree.createNewExpression(sc.nextLine());	
			System.out.println("evaluation " + tree.evaluateTree());
			System.out.print("Inorder tree : ");
			tree.inorder();
			tree.clear();
		}
	}
}
