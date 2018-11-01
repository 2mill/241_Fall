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
		} else {
			SLListNode ref = head;
			while (ref.next != null) {
				int result = (((Comparable<Object>)(ref.data)).compareTo(e)); 
				System.out.println("Looking at " + ref.data);
				System.out.println(result);
				if (result == -1 || result == 0) ref = ref.next;
				else if (result == 1) {
					SLListNode insert = new SLListNode(e, ref.next);
					ref.next = insert;
					return;
				}
			}
			super.tail = super.tail.next = new SLListNode(e, null);
			
		}
		
	}
	public int getSize() {
		return size;	
	}
	
}
