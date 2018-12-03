package collection;//Start of Lab8
public class MyBinaryTreeNode implements Comparable<MyBinaryTreeNode>{
	public Object data;
	MyBinaryTreeNode left;
	MyBinaryTreeNode right;
	public MyBinaryTreeNode(Object data) {
		left = right = null;
	
	}
	public MyBinaryTreeNode(Object d, MyBinaryTreeNode l, MyBinaryTreeNode r) {
		System.out.println(d.toString());
		data = d; 	
		System.out.println(data.toString());
		left = l;
		right = r;
	}

	@Override
	public String toString() {
		return data.toString();	
	
	}
	public int compareTo(MyBinaryTreeNode target) {
		if (target == null) {
			System.out.println("Received a null");	
		}
		else if (this.data == null) {
			System.out.println("This is null");	
		}
		Comparable<Object> change = (Comparable)target.data;	
		Comparable<Object> piece = (Comparable)data;
		return piece.compareTo(change);
	}

		
}
