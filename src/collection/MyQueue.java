package collection;
public class MyQueue{
    public SLListNode front;
    public SLListNode rear;
    public MyQueue(){
        front = rear = null;
    }
    public void clear(){
        front = rear = null;
    }
    public boolean isEmpty(){
        return front == null;
    }
    
    public void insertBack(Object element){
        if(front == null){
            front = rear = new SLListNode(element, null);
            return;
        }
        rear = rear.next = new SLListNode(element, null);
    }
    public void appendQ(MyQueue other) {
	    rear.next = other.front;
	    rear = other.rear;
    
    }
    
    public Object removeFront(){
        if(front == null){
            return null;
        }
        Object temp = front.data;
        if(front == rear){//single node
            front = rear = null;
        }
        else{
            front = front.next;
        }
        return temp;
    }
    
    public Object front(){
        if(front == null){
            return null;
        }
        return front.data;
    }
    
    public String toString(){
        String out = "The SLList contains \n";
        if(front == null){
            return  "0 nodes.";
        }
        else{
            out += "front -> \t";
        }
        SLListNode ref = front;
        while(ref.next != null){
            out += ref.data + "\t -> \t";
            ref = ref.next;
        }
        out += ref.data + "\t -> null";
        return out;
    }//check just in case
}
