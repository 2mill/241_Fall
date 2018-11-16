package collection;
public class DLListNode {
	public Object data;
	public DLListNode previous;
	public DLListNode next;


	public DLListNode(Object d) {
		data = d;	
	}
	public DLListNode (Object d, DLListNode p) {
		data = d;
		previous = p;	
	}
	public DLListNode(Object d, DLListNode p, DLListNode n) {
		data = d;
		previous = p;
		next = n;	
	}
}

