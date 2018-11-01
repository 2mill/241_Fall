package collection;
public class SLList {

	protected SLListNode head;
	protected SLListNode tail;
	public SLList() {
		head = tail = null;	
	}
	public void append(Object element) {
	
		if (head == null) {
			head = tail = new SLListNode(element, null);	
			return;
		}	
		tail = tail.next = new SLListNode(element,null);
	}
	public void insert(Object element) {
	
		if (head == null) {
			head = tail = new SLListNode(element, null);	
		} else {
			head = new SLListNode(element, head);	
		}	
	}
	public void clear() {
		head = tail = null;	
	}
	public boolean isEmpty() {
	
		if (head == null && tail == null) {
			return true;	
		}	
		else {
			return false;	
		}
	}
	public boolean remove(Object element) {
		if (head == null) {
			return false;	
		}	
		SLListNode ref = head;
		while (ref.next != tail) {
			if ((((Comparable)ref.next.data)).compareTo(element) == 0) {
				tail = ref;
				ref.next = null;
				return true;	
			}	
			ref = ref.next;
		}
		if (((Comparable)(tail.data)).compareTo(element) == 0) {
			tail = ref;
			ref.next = null;
			return true;	
		}
		return false;
	}
	public String toString() {
		String out = "The SLList contains \n";	
		if(head == null) {
			return out + "0 node.";	
		}
		else {
			out += "head -> \t";	
		}
		SLListNode ref = head;
		while (ref.next != null) {
			out += ref.data + "\t -> \t";	
			ref = ref.next;
		}
		out += ref.data + "\t -> \t";
		return out;
	}
}
