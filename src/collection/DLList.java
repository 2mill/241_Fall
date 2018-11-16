package collection;
public class DLList {
	public int size;
	public DLListNode tail;
	public DLListNode head;

	public DLList() {
		head = tail = null;
		size = 0;	
	}
	public void clear() {
		head = tail = null;	
		size = 0;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public int size() {
		return size;	
	}
	public void append(Object element) {
		DLListNode newNode = new DLListNode(element, tail);
		if (isEmpty()) {
			head = newNode;	
		} else {
			tail.next = newNode;	
		}
		tail = newNode;
		size++;
	}
	public void insert(Object element) {
		DLListNode newNode = new DLListNode(element, null, head);	
		if (isEmpty()) {
			tail = head = newNode;	
		} else {
			head.previous = newNode;
			head = newNode;	
		}
		size++;
	}
	public boolean remove(Object element) {
		if (isEmpty()) return false;
		DLListNode temp = head;
		if (temp.data.equals(element)) {
			if (size == 1) tail = head = null;
			else {
				head = head.next;
				head.previous = null;	
			}	
			size--;
			return true;
		}	
		while (temp.next != null) {
			DLListNode temptemp = temp.next;	
			if (temptemp.data.equals(element)) {
				if (temptemp == tail) {
					tail = temp;
					temp.next = null;	
				} else {
					temp.next = temptemp.next;	
					temp.next.previous = temp;
				}
				size--;
				return true;
			}
			temp = temptemp;
				
		}
		return false;

	}
	public String toString() {
		String output = new String();
		DLListNode start = head;
		while (start != null) {
		
			output += start.data.toString() + "->";	
			start = start.next;
		
		}
		output += "end";
		return output;
		
	}

	

}
