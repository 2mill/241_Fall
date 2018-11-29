package project;
import collection.MyStack;
import collection.MyQueue;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class Project3{
	public static void run() {
		File outputFile = new File("../COSC241_P3_output_ydorn0.txt");
		File inputFile = new File("../COSC241_P3_Input.txt");
		Scanner input = null;
		PrintWriter writer = null;
		try {
			if (!outputFile.exists()) {
				outputFile.createNewFile();	
			}	
		
		} catch (IOException e) {
			System.out.println("Failed to create new file");	
		}	
		try {
			input = new Scanner(inputFile);	
			writer = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			System.out.println("The File was not found for input or the Printwriter");	
		}
		while (input.hasNextLine()) {
			String inputLine = input.nextLine();
			if (!inputLine.isEmpty()) {
				inputLine = cleanUp(inputLine);
				if (inputLine.equals("Invalid Input")) {
					writer.println(inputLine);
				} else {
					MyQueue postfix = getPostfix(inputLine);	
					writer.println("Postfix expression " + postfixString(postfix));
					writer.println(inputLine + " = " + calcPostfix(postfix));
					
				}	
			}	
		}
		writer.close();

	}
	private static String postfixString(MyQueue postfix) {
		MyQueue temp = new MyQueue();	
		String output = new String();
		while (!postfix.isEmpty()) {
			Object objTemp = postfix.removeFront();		
			output += objTemp;
			temp.insertBack(objTemp);
		}
		while (!temp.isEmpty()) postfix.insertBack(temp.removeFront());
		return output;

	}
	private static String printQ(MyQueue q) {
		MyQueue temp = new MyQueue();	
		String str = new String();
		while (!q.isEmpty()) {
			temp.insertBack(q.removeFront());
			str += q.removeFront();	
		}
		return str;
	}
	private static int calcEquation(String str) {
		str = cleanUp(str);
		if (str.equals("Invalid Input")) {
			System.out.println("Error, returning 0");	
			return 0;
		}
		MyQueue postfix = getPostfix(str);
		if ((char)postfix.front() == '!') {
			System.out.println("Error, returning 0");	
			return 0;
		}
		return calcPostfix(postfix);
		
			
			
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
		//Now we can put it into a q and make sure that it is error free.
		//check paranthesis
		//Last check to make sure that the amount of operators is n - 1 the digits.
		int recordDigits = 0;
		int recordOperators = 0;
		boolean alreadyDigit = false;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				if (!alreadyDigit)
					recordDigits++;	
				alreadyDigit = true;
			} else if (str.charAt(i) != '(' && str.charAt(i) != ')') {
				recordOperators++;
				alreadyDigit = false;	
			}	
		}
		if (recordOperators!= recordDigits - 1) str = "Invalid Input";
		
		return str;
	}
	private static MyQueue getPostfix(String str) {
		MyStack operators = new MyStack();
		MyQueue postfix = new MyQueue();
		for (int i = 0; i < str.length(); i++) {
			char point = str.charAt(i);
			if (Character.isDigit(point)) {
				String collection = new String();
				int j = 0;
				for (j = i; j < str.length(); j++) {
					if (Character.isDigit(str.charAt(j))) {
						collection += str.charAt(j);	
					} else {
						break;
					}
				}
				i = j - 1;
				int value = Integer.parseInt(collection);
				postfix.insertBack(value);
				continue;
			} else {
				int pointLevel = getPresedence(point);
				if (pointLevel == 2) {
					int original = i;
					MyStack stackTemp = new MyStack();
					stackTemp.push('(');
					while (!stackTemp.isEmpty()) {
						i++;
						if (str.charAt(i) == '(') stackTemp.push('(');
						else if (str.charAt(i) == ')') stackTemp.pop();		
					}
					postfix.appendQ(getPostfix(str.substring(original + 1, i)));
					
				
				} else {
					while (!operators.isEmpty()) {
						int otherLevel = getPresedence((char)operators.peek());	
						if (otherLevel > pointLevel) {
							postfix.insertBack(operators.pop());	
						} else {
							if (otherLevel == pointLevel) {
								postfix.insertBack(operators.pop());	
								operators.push(point);
							} else {
								operators.push(point);
							}	
							break;
						}
					}
					if (operators.isEmpty()) operators.push(point);
				}
			}
		}
		while (!operators.isEmpty()) postfix.insertBack(operators.pop());
		return postfix;

}
	private static int getPresedence(char operator) {
		String operators0 = "+-";
		String operators1 = "/*%";
		String operators2 = ")(";
		if (operators0.indexOf(operator) != -1) return 0;	
		if (operators1.indexOf(operator) != -1) return 1;	
		if (operators2.indexOf(operator) != -1) return 2;	
		else return -1;
		
			
	}
	private static int calcPostfix(MyQueue postfix) {
		MyStack forNumbers = new MyStack();
		while (!postfix.isEmpty()) {
			Object point = postfix.removeFront();
			if (point instanceof Integer) {
				forNumbers.push((int)point);
			} else {
				char temp = (char)point;
				//pop two numbers
				int second = (int)forNumbers.pop();
				int first = (int)forNumbers.pop();
				int result = 0;
				switch(temp) {
					case '+' :
						result = first + second;		
						break;
					case '-' :
						result = first - second;		
						break;
					case '%' : 
						result = first % second;
						break;
					case '*' :
						result = first * second;		
						break;
					case '/' :
						result = first / second;		
						break;
				
				
				}
				forNumbers.push(result);
			}
		}	
		return (int)forNumbers.pop();
	
	}
}
