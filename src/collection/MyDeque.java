package collection;
public class MyDeque extends DLList{
	public MyDeque() {
		super();	
	}
	public Object popFirst() {
		if (head == null) {
			return null;
		}
		DLListNode temp = head;
		if (tail == head) tail = head = null;
		else {
			head.next.prev = null;
			head = head.next;	
		}
		return temp.data;
				
	}
	public Object popLast() {
		if (tail == null) {
			return null;
		}	
		DLListNode temp = tail;
		if (tail == head) tail = head = null;
		else {
			tail.prev.next = null;
			tail = tail.prev;	
		}
		
		return temp.data;
	}
	public Object peekFirst() {
		return head;	
	}
	public Object peekLast() {
		return tail;	
	}

}
