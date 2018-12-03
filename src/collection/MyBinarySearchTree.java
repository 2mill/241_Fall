package collection;

public class MyBinarySearchTree extends MyBinaryTree {
	MyBinaryTreeNode root;
       public MyBinarySearchTree() {
            root = null;
       }
       public void insert(Object newItem) {
	    MyBinaryTreeNode newNode = new MyBinaryTreeNode(newItem);
	    if (newNode != null) System.out.println("Node is not null");
	    if (newNode.data == null) System.out.println("new node data is null");
	    System.out.println(newNode.toString());
            root = insertHelper(root, newNode);
       }
       public MyBinaryTreeNode insertHelper(MyBinaryTreeNode rt, MyBinaryTreeNode newNode) {
             if (rt == null) {
                   rt = newNode;
		   System.out.println("Made rt new node");
                   return rt;
             }
	     System.out.println(newNode.data.toString());
             if (newNode.compareTo(rt) > 0) {
               rt.left = insertHelper(rt.left, newNode); 
             } else {
                   rt.right = insertHelper(rt.right, newNode);
             }
             return rt;
       }
       public String toString() {
       
	       return toString(root);
       }
       private String toString(MyBinaryTreeNode part) {
      		String str = new String(); 
      		if (part.data == null) {
			return "|-"+part.data;	
		} else {
			str += "|-" + toString(part.right); 
			str += "|-" + toString(part.left);
		}
		return str;
       }
       private boolean isLeaf(MyBinaryTreeNode node) {
      		return node.left == null && node.right == null; 
       }



}
