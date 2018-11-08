package collection;
public class MyBinaryTreeNode implements Comparable<MyBinaryTreeNode>{
	public Object data;
	MyBinaryTreeNode left;
	MyBinaryTreeNode right;
	public MyBinaryTreeNode(Object data) {
		left = right = null;
		data = this.data;	
	
	}
	public MyBinaryTreeNode(Object d, MyBinaryTreeNode l, MyBinaryTreeNode r) {
		data = d; 	
		left = l;
		right = r;
	}

	@Override
	public String toString() {
		return data.toString();	
	
	}
	public int compareTo(MyBinaryTreeNode target) {
	
		Comparable<Object> change = target.data;	
		
	}

		
}
