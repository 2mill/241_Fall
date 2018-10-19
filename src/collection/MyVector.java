package collection;
import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;
import java.util.Arrays;
/**
 *
 * @author 2 Mill
 * @version 2018.9.19
 */
public class MyVector implements Cloneable {
    private int size;
    private Object[] data;
    private static final int INITIAL_SIZE = 100;
    /**
     * Constructor for MyVector. Will set the size of the array to 100
     * and it will initlaize size to 0
     */
    public MyVector() {
        data = new Object[INITIAL_SIZE];
        size = 0;
    }
   /**
    * Allows you make an Object array into a vector array
    * @param arr the array that will be wrapped into the vecto
    */ 
    public MyVector(Object[] arr) {
        data = arr;
        
        size = arr.length;
        
    }
    /**
     * Appends the given element onto the end of the vector
     * @param element the element that will be appended
     */
    public void append(Object element) {
        if (size == data.length) {
            expand();
        }
        data[size] = element;
        size++;
    }
    /**
     * expands the array when something is added that's out of bounds
     */
    private void expand() {
        Object[] temp = new Object[size * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
    /**
     * clears the entire vector and limits it back to the original vector size
     */
    public void clear() {
        data = new Object[INITIAL_SIZE];
	size = 0;
    }
    /**
     * Checks to see if the given Obj exists in the vector
     * @param element the Obj that will be checked in the array
     * @return returns true or false depending on if it was found
     */
    public boolean contains(Object element) {
        for (Object j : data) {
            if (element.equals(j)) return true;
        }
        return false;
    }
    /**
     * Returns element at the given index
     * If the element is not found, a null is returned
     * @param index the index that would like to be retrieved
     * @return the obj at the given index
     */
    public Object elementAt(int index) {
	   if (index > size - 1 || index < 0) return null;
	   else return data[index];
    }
    public int indexOf(Object element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) return i;
        }
        return -1;
    }
    /**
     * Places an element at a specific point and moves every element behind it back one space
     * @param index the index that the element that was placed
     * @param element the element htat will be placed in
     * @return returns true of false depending on if it was a successful operation
     */
    public boolean inserAt(int index, Object element) {
	    if (index < 0 || index >= size)
		    return false;
	    if (size == data.length) expand();
	    for (int i = size; i > index; i--) {
	   	 data[i] = data[i-1];
	    }
	    data[index] = element;
	    size++;
	    return true;
    }
    /**
     * Checks if the vector is empty or not
     * @return returns a true or false depending on if it is or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * removes an element at a given index.
     * @param index the index that you want the element to be removed at
     * @return true or false depending on if the operation was a success.
     */
    public boolean removeAt(int index) {
        for (int i = index; i < data.length - 1; i++) {
            /**
             * This basically functions by taking the thing that's supposed to be
             * and moving it back until finds the ending which is the signal
             * by finding a null or just finding the end
             * This is because it's meant to be dynamic
             */
            if (data[i+1] == null) {
                data[i] = null;
                size--;//We have to decrease the size of the array here
		return true;//removal was successful
            }
            Object temp = data[i];
            data[i] = data[i+1];
            data[i+1] = temp;
        }
	return false;
        
    }
    /**
     * Removes the first occurance of the first object in the given parameter
     * @param element the element that will be removed
     * @return true or false if it was a successful operation
     */
    public boolean remove(Object element) {
        
        for (int i = 0; i < data.length; i++) {
            Object o = data[i];
            if (o == null) break;
            else if (o.equals(element)) removeAt(i);
        }
        
        return false;
    }
    /**
     * Replaces the given index with the element given
     * @param index the index that will be removed
     * @param element the element that it will be replaced with
     */
    public void replace(int index, Object element) {
	if (index < 0 || index > size) throw new IndexOutOfBoundsException("Given index is out of bounds");
        data[index] = element;
    }
    /**
     * Gives the current size of the array
     * @return the size of the array
     */
    public int size() {
        return size;
    }
    
    /**
     * Makes a shallow copy of the object
     * @return a shallow copy of the vector
     */
    @Override
    public MyVector clone() throws CloneNotSupportedException {
        Object[] temp = new Object[data.length];
        System.arraycopy(data, 0, temp, 0, temp.length); //basic copying
        return new MyVector(temp);
	
    }
    /**
     * Removes elements from the given range. If the range is out of bounds, it will get capped off to the proper size;
     * @param fromIndex the index that the removal will be started at
     * @param toIndex the index that the removal will end.
     */
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex >= toIndex)
            return;
        if (fromIndex < 0)
            fromIndex = 0;
        if (toIndex >= size)
            toIndex = size;
        
        int dist = toIndex - fromIndex;
        
        for (int i = fromIndex; i < toIndex; i++)
            data[i] = data[i + dist];
        
        for (int i = toIndex; i < size; i++)
            data[i] = null;
	size -= dist;	
        
        
    }
    /**
      Returns the array as a string
     * @return the vector represented in string form
     */
    public String toString() {
        String complete = "[ ";
        for (int i = 0; i < size; i++) {
            complete += data[i];
	    complete = i != size - 1 ? complete + ", " : complete;
        }//This needs some adjustments
        return complete + "]";
    }
    /**
     * Reverse the order of the vector
     */
    public void reverse() {
        for (int i = 0 ; i < size/2; i++) {
	   //System.out.println("Array size is: " + size);
           // System.out.println("Grabbing " + data[size - 1 - i] + " and replacing it with " + data[i]);
            Object temp = data[size - 1 - i];
            //System.out.println(temp);
            data[size - 1 - i] = data[i];
            //System.out.println(toString());
            data[i] = temp;
           //System.out.println(toString());
           //System.out.println();
        }
    }
    /**
     * Merges the vector with the given vector
     * @param vector2 the vector that will be appended to the end.
     */
    public void merge(MyVector vector2) {
	if (vector2 instanceof MyVector) 
        	for (int i = 0; i < vector2.size(); i++) {
            		append(vector2.elementAt(i));
        	}
    }
    
}
