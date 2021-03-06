package collection;
public class SortedSLList extends SLList {
	private int size;

	public SortedSLList() {
		super();	
		size = 0;
	}
	@Override
	public void insert(Object e) {
		size++;
		if (this.isEmpty()) {
			super.head = super.tail =  new SLListNode(e, null);	
			return;
		} else {
			SLListNode ref = head;
			{
				int result = (((Comparable<Object>)(head.data)).compareTo(e)); 
				if (result > 0) {
					head = new SLListNode(e, head);
					return;
				}
			}
			while (ref.next != null) {
				int result = (((Comparable<Object>)(ref.next.data)).compareTo(e)); 
				if (result == -1 || result == 0) ref = ref.next;
				else if (result == 1) {
					ref.next = new SLListNode(e,ref.next);
					return;
				}
			}
			super.tail = super.tail.next = new SLListNode(e,null);
		}
		
	}
	public int size() {
		return size;	
	}
	@Override
	public void append(Object e) {
		//Append should not work here, because it needs to stay sorted, but I do not want
		//to rewrite but instead inherit
		insert(e);	
	}
	//Inherits toString
	
}
