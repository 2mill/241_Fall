package collection;
public abstract class MyBinaryTree {

	public MyBinaryTreeNode root;
	public void clear() {
		root = null;	
	}
	public int size() {
		return sizeHelper(root);		
	}
	private int sizeHelper(MyBinaryTreeNode rt) {
		//base case	
		if (rt == null) return 0;
		return sizeHelper(rt.left)+sizeHelper(rt.right) + 1;
	}
	private int heightHelper(MyBinaryTreeNode rt, int ht) {
		if (rt == null) return ht;	
		return Math.max(heightHelper(rt.left, ht + 1), heightHelper(rt.right, ht + 1));
	
	}

}