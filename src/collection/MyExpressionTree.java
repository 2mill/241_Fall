package collection;
import collection.MyQueue;
import project.Project3;
import java.util.Scanner;
public class MyExpressionTree extends MyBinaryTree {
	public MyExpressionTree(String input) {	
		input = Project3.cleanUp(input);
		if (input.equalsIgnoreCase("Invalid Input")) System.out.println("Invalid input");
		else {
			input = Project3.postfixString(Project3.getPostfix(input));
			constructPostfix(input);
			inorder();
		}
	}
	public void clear() {
		root = null;	
	}
	private void constructPostfix(String input) {
		System.out.println("Received " + input);
		Scanner forInput = new Scanner(input);
		MyStack temp = new MyStack();
		while (forInput.hasNext()) {
			if (forInput.hasNextInt()) {
				System.out.println("Found a number");
				temp.push(new MyBinaryNode(forInput.nextInt())); 
			} else {
				System.out.println("Found a symbol");
				MyBinaryNode symbol = new MyBinaryNode(forInput.next().charAt(0));
				insertNode(symbol, (MyBinaryNode)temp.pop());
				insertNode(symbol, (MyBinaryNode)temp.pop());
				temp.push(symbol);
			}	
		}
		System.out.println(temp);
		root = (MyBinaryNode)temp.pop();
	}
	private void insertNode(MyBinaryNode root, MyBinaryNode node) {
		MyQueue q = new MyQueue();	
		q.insertBack(root);
		while (!q.isEmpty()) {
			MyBinaryNode chosen = (MyBinaryNode)q.removeFront();	
			if (chosen.leftChild == null) {
				chosen.leftChild = node;	
				break;
			} else {
				q.insertBack(chosen.leftChild);	
			}
			if (chosen.rightChild == null) {
				chosen.rightChild = node;	
				break;
			} else {
				q.insertBack(chosen.rightChild);	
			}
			
		}
	}
}
