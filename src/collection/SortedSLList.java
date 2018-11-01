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
			{
				int result = (((Comparable<Object>)(head.data)).compareTo(e)); 
				if (result > 0) {
					head = new SLListNode(e, head);
				}
			
			}
			while (ref.next != null); {
				int result = (((Comparable<Object>)(ref.next.data)).compareTo(e)); 
				System.out.println("Looking at " + ref.next.data);
				System.out.println(result);
				if (result == -1 || result == 0) ref = ref.next;
				else if (result == 1) {
					ref.next = new SLListNode(e,ref.next);
					return;
				}
			}
		}
		
	}
	public int getSize() {
		return size;	
	}
	
}
