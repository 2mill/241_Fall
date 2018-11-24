package project;
import collection.MyStack;
import collection.MyQueue;
import java.util.Scanner;
public class Project2 {
	public static void run() {
		Scanner	sc = new Scanner(System.in);
		System.out.println("Please input an equation to be proccs");
		MyQueue postfix = null;
		for (int i = 0; i < 5; i++) {
			String temp = null;
			temp = sc.nextLine();
			//cleanup is functioning
			temp = cleanUp(temp);
			postfix = getPostfix(temp);
			System.out.println("result " + calcPostfix(postfix));
			
		}
	}
	public static String printQ(MyQueue target) {
		MyQueue other = new MyQueue();	
		String output = new String();
		while (!target.isEmpty()) {
			char holder = (char)target.removeFront();
			output += holder;
			other.insertBack(holder);
		}
		return output;
			
	}
	private static String cleanUp (String str) {
		str = str.replaceAll(" ", "");
		str = str.replaceAll("x", "*");
		str = str.replaceAll("X", "*");
		//check for paranthesis w/o * on it, place an x
		MyStack checkParanthesis = new MyStack();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				checkParanthesis.push(str.charAt(i));
				if (i != 0) {
					if (str.charAt(i - 1) != '*' && getPresedence(str.charAt(i - 1)) == -1) {
						str = str.substring(0, i) + "*" + str.substring(i);	
						i++;
					}	
				}	
			} else if (str.charAt(i) == ')') {
				checkParanthesis.pop();
				if (i + 1 != str.length()) {
					if (str.charAt(i + 1) != '*' && getPresedence(str.charAt(i + 1)) == -1) {
						str = str.substring(0, i + 1) + "*" + str.substring(i+1);	
					}	
				}	
			}
		}	
		if (!checkParanthesis.isEmpty()) str = "Invalid Input";
		//check paranthesis
		return str;
	}
	private static MyQueue getPostfix(String str) {
		System.out.println("Received " + str);
		MyStack operators = new MyStack();
		MyQueue postfix = new MyQueue();
		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {//This will go through the entire string
			char point = str.charAt(i);
			int pointLevel = getPresedence(point);
			if ( pointLevel != -1) {//checks to see if it is an operator using the level checker down below.
				if (postfix.isEmpty()) postfix.insertBack(point);//this is an instance where the postfix is empty so we automatically add.	
				else {
					//first we need to check if the character has a paranthesis, because it get's it's own treatment in that instance.
					if (pointLevel== 2) {
						//reinsert it back into this function and append the result onto the back of the original q
						//handling operators is stable right now, so now we cna dive into the paranthesis
						//first we need to grab a snippet with the paranthesis
						if (point == '(') {
							//start a new stack, hold this position, push this open paran and pop for closed ones until empty
							//hop i appropriately so that we are already at the correct position for the substring
							//and we are already at the correct position to continue from
							//We do need a holder for the original position
							int originalPosition = i;
							MyStack tempStack = new MyStack();
							tempStack.push(point);
							while (!tempStack.isEmpty()) {
								i++;	
								if (str.charAt(i) == '(') tempStack.push(str.charAt(i));
								else if(str.charAt(i) == ')') tempStack.pop();
							}
							String temp = str.substring(originalPosition + 1, i);
							System.out.println(temp);
							postfix.appendQ(getPostfix(temp));
							
						}
					

					}
					else {
						//This needs to change, because we pop until we find something that is not.
						while (!operators.isEmpty()) { //run until the end, because we known once it's empty we can definetly insert
							char top = (char)operators.peek();	
							int topLevel = getPresedence(top);
							if (topLevel > pointLevel) { //In this instance, the presedence of the top is higher, thus we pop and put it in hte q
								postfix.insertBack(operators.pop());
						
							} else {
								//pop the thing that has the same presedence and put it into the list.
								//This only applies when the presedence is the same and does not apply in any other situation
								if (topLevel == pointLevel) {
									postfix.insertBack(operators.pop());	
									operators.push(point);
								} else {
									operators.push(point);//At this point we know it does not have higher presedence, so we can push	
								}
								break; //we brake at this point, because we have reached our destination w/ the operator
							}
						}
						if (operators.isEmpty()) operators.push(point);
					
					}	
					//pop the top most value of the stack and compare. If it's level is higher than the point
					//then we insert it into the 		
				}

			} else if (Character.isDigit(point)) {
				//in this instance w/ it being a number, we slap it into the thing
				postfix.insertBack(point);	
			} else {
				//This is an instance where an unkown character is received
				//The postfix will be cleared and an ! will be inserted into the front
				//this means that when I do a final check to see if the expression is valid, I have a firm understanding.
				postfix.clear();
				postfix.insertBack('!');	
			}
		
		}
		while (!operators.isEmpty()) {
			postfix.insertBack(operators.pop());	
		}
		return postfix;

	}
	private static int calcPostfix(MyQueue postfix) {
		MyStack forNumbers = new MyStack();
		while (!postfix.isEmpty()) {
			char point = (char)postfix.removeFront();	
			if (Character.isDigit(point)) {
				forNumbers.push((int)point - 48);
			} else {
				//pop two numbers
				int second = (int)forNumbers.pop();
				int first = (int)forNumbers.pop();
				int result = 0;
				switch(point) {
					case '+' :
						result = first + second;		
						break;
					case '-' :
						result = first - second;		
						break;
					case '*' :
						result = first * second;		
						break;
					case '/' :
						result = first / second;		
						break;
				
				
				}
				System.out.println("Pushing " + result);
				forNumbers.push(result);
			}
		}	
		return (int)forNumbers.pop();
	
	}
	private static int getPresedence(char operator) {
		String operators0 = "+-";
		String operators1 = "/*";
		String operators2 = ")(";
		if (operators0.indexOf(operator) != -1) return 0;	
		if (operators1.indexOf(operator) != -1) return 1;	
		if (operators2.indexOf(operator) != -1) return 2;	
		else return -1;
		
			
	}
}
