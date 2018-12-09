package collection;
import collection.MyQueue;
import collection.MyBinaryNode;
public class MyBinaryTree {
	protected MyBinaryNode root; 
	protected static String output;
	public MyBinaryTree() {
		root = new MyBinaryNode(null);	
	}
	public MyBinaryTree(Object item) {
		root = new MyBinaryNode(item);	
	}
	public int numberOfNodes() {
		return numberOfNodes(root);
	}
	public int numberOfNodes (MyBinaryNode node) {
		if (node == null) {
			return 0;	
		} else {
			return (numberOfNodes(node.leftChild) + 1 + numberOfNodes(node.rightChild));	
		}	
	}
	public int depth() {
		return depth(root);	
	} 
	private int depth(MyBinaryNode node) {
		if (node == null) return 0;	
		else {
			int leftDepth = depth(node.leftChild);
			int rightDepth = depth(node.rightChild);			
			if (leftDepth > rightDepth) {
				return leftDepth + 1;	
			} else {
				return rightDepth + 1;	
			}
		}
	}
	public void insert(Object item) {
		if (root.data == null) root = new MyBinaryNode(item);
		else
			insertHelper(root, item);	
	}
	private void insertHelper(MyBinaryNode root, Object key) {
		MyQueue q = new MyQueue();	
		q.insertBack(root);
		int levels = 0; 
		while (!q.isEmpty()) {
			MyBinaryNode chosen = (MyBinaryNode)q.removeFront();	
			if (chosen.leftChild == null) {
				MyBinaryNode temp = new MyBinaryNode(key);
				chosen.leftChild = temp;
				break;
			} else {
				q.insertBack(chosen.leftChild);	
				levels++;
			}
			if (chosen.rightChild == null) {
				MyBinaryNode temp = new MyBinaryNode(key);
				chosen.rightChild = temp;	

				break;
			} else {
				q.insertBack(chosen.rightChild);	
			
			}
		}
	
	}
	private void postorder(MyBinaryNode root) {
		if(root==null) return;	
		postorder(root.leftChild);
		postorder(root.rightChild);
		System.out.print(root.data.toString() + " ");
	}
	private void inorder(MyBinaryNode root) {
		if (root== null) {
			return;	
		}
		inorder(root.leftChild);
		System.out.print(root.data.toString() + " ");
		inorder(root.rightChild);	
	}
	private void preorder(MyBinaryNode root) {
		if (root == null) {
			return;		
		}
		System.out.print(root.data.toString() + " ");
		preorder(root.leftChild);
		preorder(root.rightChild);
	
	}
//    public String preOrder(){
//    output += "";
//    preOrder(root);
//        return output;
//    }
//   public void preOrder(MyBinaryNode root) {
//      if (root == null) return;
//          output += root.data;
//    preOrder(root.leftChild);
//    preOrder(root.rightChild);
//   }
//    public String inOrder(){
//    String output = new String();
//    inOrder(root);
//    return output;
//    }
//   public void inOrder(MyBinaryNode root) {
//    if (root == null) return;
//      inOrder(root.leftChild);
//    output += root.data.toString();
//    inOrder(root.rightChild);
//   }
//    public String postOrder(){
//    output = "";
//    postOrder(root);
//        return output;
//    }
//    private void postOrder(MyBinaryNode root) {
//    if (root == null) return;
//       postOrder(root.leftChild);
//    postOrder(root.rightChild);
//    output += root.data;
//    }
    
    public String inOrder(){
        String o = "";
        output="";
        o += inOrderHelper(root);
        return o;
    }
    
    private String inOrderHelper(MyBinaryNode rt){
        if (rt == null) return output; //return rt?
        inOrderHelper(rt.leftChild);
        output+= (rt.data);
        inOrderHelper(rt.rightChild);
        return output;
    }
    public String postOrder(){
        String o = "";
        output="";
        o += postOrderHelper(root);
        return o;
    }
    
    private String postOrderHelper(MyBinaryNode rt){
        if (rt == null) return output; //return rt?
        postOrderHelper(rt.leftChild);
        postOrderHelper(rt.rightChild);
        output += (rt.data);
        return output;
    }
    public String preOrder(){
        String o = "";
        output="";
        o += preOrderHelper(root);
        return o;
    }
    
    private String preOrderHelper(MyBinaryNode rt){
        if (rt == null) return output; //return rt?
        output += (rt.data);
        preOrderHelper(rt.leftChild);
        preOrderHelper(rt.rightChild);
        return output;
    }
    
}
