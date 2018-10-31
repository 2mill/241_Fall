package collection;

public class Node {
	private Object stuff;
	Node previous;

	public Node(Node old, Object data) {
		previous = old;	
		stuff = data; 
	}

}
