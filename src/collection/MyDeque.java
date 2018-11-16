package collection;
public class MyDeque extends DLList{
	public MyDeque() {
		super();	
	}
	public Object popFirst() {
		if (head == null) {
			return null;	
		}	
		Object temp = head;
		if (head.next != null) {
			head.next.previous = null;
			head = head.next;
		} else {
			head = tail = null;		
		}
		return temp;
				
	}
	public Object popLast() {
		if (tail == null) {
			return null;
		}	
		Object temp = tail;
		if (tail == head) {
			tail = head = null;	
		}
		else {
			tail.previous.next = null;
			tail.previous = tail;	
		}
		return temp;
	}
	public Object peekFirst() {
		return head;	
	}
	public Object peekLast() {
		return tail;	
	}

}
