package collection;

public class MyBinarySearchTree {
	MyBinaryTreeNode root;
       public MyBinarySearchTree() {
            root = null;
       }
       public void insert(Object newItem) {
          
            root = insertHelper(root, new MyBinaryTreeNode(newItem));
       }
       public MyBinaryTreeNode insertHelper(MyBinaryTreeNode rt, MyBinaryTreeNode newNode) {
             if (rt == null) {
                   rt = newNode;
                   return rt;
             }
             if (newNode.compareTo(rt) > 0) {
               rt.left = insertHelper(rt.left, newNode); 
             } else {
                   rt.right = insertHelper(rt.right, newNode);
             }
             return rt;
       }


}
