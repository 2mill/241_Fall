package lab;
import collection.MyBinarySearchTree;
import java.util.Random;
public class Lab9 {

	public static void test() {

		MyBinarySearchTree tree = new MyBinarySearchTree();		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < 50; i++) {
			int num = r.nextInt(301);
			tree.insert(num);	
		}
		System.out.println("Inorder: ");
		tree.inorder();
		System.out.println("Preorder: ");
		tree.preorder();
		System.out.println("Postorder: ");
		tree.postorder();
		tree.deleteSmallest();
		tree.deleteLargest();
		tree.delete(50);
		tree.delete(100);
		tree.delete(150);
		System.out.println("After removal instructions");
		System.out.println("Inorder: ");
		tree.inorder();
		System.out.println("Preorder: ");
		tree.preorder();
		System.out.println("Postorder: ");
		tree.postorder();
	}
	

}
