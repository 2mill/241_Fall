package collection;
import collection.MyQueue;
import project.Project3;
import java.util.Scanner;
import java.util.Arrays;
public class MyExpressionTree extends MyBinaryTree {
	public MyExpressionTree(String input) {	
		input = Project3.cleanUp(input);
		if (input.equalsIgnoreCase("Invalid Input")) System.out.println("Invalid input");
		else {
			System.out.println(input);
			String tempString = new String();
			System.out.println("Expression before rever " + input);
			input = prepForReversal(input);
			System.out.println("Expression after reversing ints " + input);
			tempString = "";
			char[] forString = input.toCharArray();
			for (int i = 0; i < forString.length; i++) {
				if (forString[i] == ')') tempString += '(';
				else if (forString[i] == '(') tempString += ')';
				else tempString += forString[i];
			}
			input = tempString;
			System.out.println("Reversed expression " + input);
			input = modifiedPostfixString(Project3.getPostfix(input));
			constructPostfix(input);
			inorder();
			preorder();
			postorder();
		}
	}
	public void clear() {
		root = null;	
	}
	private String prepForReversal(String input) {
		String tempString = new String();
		String collect = new String();
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				collect += input.charAt(i);	
			} else {
				tempString += (new StringBuilder(collect)).reverse().toString();
				tempString += input.charAt(i);
				collect = "";	
			}	
		}
		if (!collect.isEmpty()) tempString += (new StringBuilder(collect)).reverse().toString();
		input = "";
		input += tempString;
		return (new StringBuilder(input)).reverse().toString();
	
	}
	private void constructPostfix(String input) {
		System.out.println("Received " + input);
		String collect = "";
		String tempString = "";
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				collect += input.charAt(i);	
			} else {
				tempString += collect + " ";
				tempString += input.charAt(i);
				collect = "";	
			}	
		}
		if (!collect.isEmpty()) {
			tempString += collect;	
		}
		input = tempString;
		System.out.println("Input is now " + input);
		Scanner forInput = new Scanner(input);
		MyStack temp = new MyStack();
		while (forInput.hasNext()) {
			if (forInput.hasNextInt()) {
				temp.push(new MyBinaryNode(forInput.nextInt())); 
			} else {
				MyBinaryNode symbol = new MyBinaryNode(forInput.next().charAt(0));
				insertNode(symbol, (MyBinaryNode)temp.pop());
				insertNode(symbol, (MyBinaryNode)temp.pop());
				temp.push(symbol);
			}	
		}
		root = (MyBinaryNode)temp.pop();
	}
	private String modifiedPostfixString(MyQueue postfix) {
		String output = "";
		while (!postfix.isEmpty()) {
			output += postfix.removeFront().toString() + " ";
		}		
		return output;
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
