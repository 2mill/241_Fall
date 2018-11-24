package collection;
public class DLList{
    public DLListNode head;
    public DLListNode tail;
    public DLList(){
        head = tail = null;
    }
    
    public void append (Object element){
        if(head == null){
            head = tail = new DLListNode(element, null, null);
            return;
        }
        tail = new DLListNode(element, tail, null);
        tail.prev.next = tail;
    }
    
    public void insert(Object element){
        if(head == null){
            head = tail = new DLListNode(element, null, null);
        }
        else{
            head.prev = new DLListNode(element, null, head);
            head = head.prev;
        }
    }
    
    public void clear(){
        //finish
    }
    
    public void remove (Object element){
        if(head == null) return;
        if(((Comparable)head.data).compareTo(element) == 0){
            if(head == tail){//single node case
                head = tail = null;
            }
            else{
                head = head.next;
                head.prev = null;
            }
            return;
        }
        if(head == tail) return;
        DLListNode ref = head.next;
        while(ref != tail){
            if(((Comparable)ref.data).compareTo(element) == 0){
                ref.prev.next = ref.next;
                ref.next.prev = ref.prev;
                return;
            }
            ref = ref.next;
        }
        if(((Comparable)tail.data).compareTo(element) == 0){
            tail = tail.prev;
            tail.next = null;
        }
    }
    
    public String toString(){
	   String output = new String();
	   if (head == null) {
	  	output += "The list is empty"; 
	   } else {
	  	DLListNode temp = head;	 
		while (temp != null) {
			output += temp.data.toString() + "<-->";	
			temp = temp.next;
		}
	   }
	   return output;
    }
}
