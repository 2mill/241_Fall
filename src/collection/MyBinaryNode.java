package collection;
public class MyBinaryNode implements Comparable<MyBinaryNode>{
	public Object data;
	public MyBinaryNode leftChild;
	public MyBinaryNode rightChild;

	public MyBinaryNode(Object item) {
		leftChild = null;
		rightChild = null;	
		data = item;
	}
	public int compareTo(MyBinaryNode obj) {
		Comparable<Object> first = (Comparable<Object>)obj.data;
		Comparable<Object> second = (Comparable<Object>)this.data;
		return second.compareTo(first);

	}
	public void printNode() {
		printNode(this);			
	}
	public void printNode(MyBinaryNode node) {
		if (node == null) {
			return;	
		}	
		
	}
	public String toString() {
		return node.data.toString();	
	}

}
