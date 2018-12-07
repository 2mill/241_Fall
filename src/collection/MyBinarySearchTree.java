package collection;
import collection.MyBinaryTree;
public class MyBinarySearchTree extends MyBinaryTree {
	public MyBinarySearchTree(Object item) {
		root = new MyBinaryNode(item);	
	}
	public MyBinarySearchTree() {
		root = null;	
	}
	@Override
	public void insert(Object item) {
		if (root == null) root = new MyBinaryNode(item);
		else root = insertHelper(root, item);
	
	} 
	private MyBinaryNode insertHelper(MyBinaryNode node, Object item) {
		if (node== null) { //Base case
			node = new MyBinaryNode(item);	
			return node;
		}
		if (node.compareTo(new MyBinaryNode(item)) == 1) {
			node.leftChild = insertHelper(node.leftChild, item);	
		} else if (node.compareTo(new MyBinaryNode(item)) == -1){
			node.rightChild = insertHelper(node.rightChild, item);	
		}
		return node;
	}
	//Search binary tree
	private boolean searchTree(MyBinaryNode node, Object key) {
		if (node == null) return false;	
		else if (node.data.equals(key)) return true;
		else if (node.compareTo(new MyBinaryNode (key)) >= 0) return searchTree(node.leftChild, key);
		else return searchTree(node.rightChild, key);
	}
	public void delete(Object key) {
		delete(root, key);
	}
	private MyBinaryNode delete(MyBinaryNode root, Object key) {
		if (root ==  null) {
			return root;	
		}
		else if (root.compareTo(new MyBinaryNode(key)) > 0) {
			root.leftChild = delete(root.leftChild, key);	
		} else if (root.compareTo(new MyBinaryNode(key)) < 0) {
			root.rightChild = delete(root.rightChild, key);	
		}
		else {
			if (root.leftChild == null && root.rightChild == null) {
				return null;	
			}	
			else if (root.leftChild == null) {
				return root.rightChild;	
			}
			else if (root.rightChild == null) {
				return root.leftChild;	
			}
			else {
				MyBinaryNode temp = findMin(root.rightChild);
				root.data = temp.data;	
				root.rightChild = delete(root.rightChild, temp.data);
			}
		}
		return root;
	}
	public void deleteSmallest() {
		MyBinaryNode smallest = findMin(root);
		delete(smallest.data);
	}
	public void deleteLargest() {
		MyBinaryNode largest = findMax(root);
		delete(largest.data);
	}
	private MyBinaryNode findMin(MyBinaryNode root) {
		while (root.leftChild != null) {
			root = root.leftChild;		
		}
		return root;
	}
	private MyBinaryNode findMax(MyBinaryNode root) {
		while (root.rightChild != null) {
			root = root.rightChild;		
		}
		return root;
	}
}
