package project;
import java.util.Scanner;
import collection.MyBinaryTree;
import collection.MyExpressionTree;
public class Project4 {
	public static void run() {
		Scanner sc = new Scanner(System.in);	
		MyExpressionTree tree = null;
		for (int i = 0; i < 5; i++) {
			tree = new MyExpressionTree(sc.nextLine());
			System.out.println("Inorder");
			tree.inorder();
		}
	}
}
