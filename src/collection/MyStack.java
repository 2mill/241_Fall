package collection;
import collection.SLListNode;
public class MyStack{
    public SLListNode top;
    //public MyStack(){
    //}
    public MyStack() {
   	top = null; 
    }
    
    public void clear() {
   	top = null; 
    }
    //public void clear(){
    //}
    
    //public void isEmpty(){
    //}
    public boolean isEmpty() {
   	return top == null; 
    }
    
    public Object pop(){
        if(top == null){
            return null;
        }
        Object temp = top.data;
        top = top.next;
        return temp;
    }
    
    public void push(Object element){
        top = new SLListNode(element, top);
    }
    
    public Object peek(){
        if(top == null){
            return null;
        }
        return top.data;
    }
    //public String toString(){
    public String toString() {
	    SLListNode temp = top;
	    String str = new String();
	    System.out.println("The stack contains the following values");
	    while (temp != null) {
		    str = str + temp.data.toString() + "-";
		    temp = temp.next;
	    }
	    str = str + "]";
	    return str;
    }
}
//Big O notation: 1 (because there are no loops or recursion method)

