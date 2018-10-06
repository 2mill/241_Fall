package collection;
public class MySet extends MyVector {
	
	/**
	 * Constructor for MySet, and puts in every in the array
	 * @param arr the array that will be added
	 */
	public MySet(Object[] arr) {
		super();
		for (Object a : arr) add(a);
	}
	/**
	 * Constructor that creates an empty set
	 */
	public MySet() {
		super();	
	}
	/**
	 * Adds an element to the set, but ignores duplicates
	 * @param element the element that will be added to the set
	 * @return true/false depending on if it was added.
	 */
	public boolean add(Object element) {
		if (!super.contains(element)) {
			super.append(element);
			return true;	
		}
		return false;
	}
	/**
	 * Returns the size of the set
	 * @return the size of the set
	 */
	public int cardinality() {
		return super.size();	
	}
	/**
	 * Returns the complement of this object, and the input set (this - B)
	 * @param B the set that will complement this set
	 * @return set this -  set B
	 */
	public MySet complement(MySet B) {
		MySet temp = this.clone();
		for (int i = 0; i < B.size(); i++) {
			temp.remove(B.elementAt(i));	
		}
		return temp;
	}
	/**
	 * appends the given object to the set and ignores duplicates
	 * @param element the Object that will be added to the end of the set
	 * @return true/false if it was a complete operation
	 */
	@Override
	public void append(Object element) {
		this.add(element);	
	}
	/**
	 * Creates a shallow clone of the set
	 */
	@Override
	public MySet clone() {
		MySet temp = new MySet();
		for (int i = 0; i < this.size(); i++) {
			temp.add(this.elementAt(i));	
		}
		return temp;
			
	}
	/**
	 * Gives the intersection of this set and the given input set
	 * @param B the input set that will intersect this set
	 * @return The intersect of this and B in the form of a new MySet
	 */
	public MySet intersection(MySet B) {
		//Make an empty set
		MySet temp = new MySet();
		for (int i = 0; i < B.size(); i++) {
			if (this.contains(B.elementAt(i))) temp.add(B.elementAt(i));	
		}
		return temp;
	}
	/**
	 * Gives the subset of this set and the given input set
	 * @param B the input set that will subset this set
	 * @return The subset of this and B in the form of a new MySet 
	 */
	public boolean subsetOf(MySet B) {
		if (this.size() > B.size()) return false;	
		for (int i = 0; i < this.size(); i++) {
			if (!B.contains(this.elementAt(i)));	
		}
		return true;
	}
	/**
	 * Gives the symmetricDifference of this set and the given input set
	 * @param B the input set that will show the symmetricSystem
	 * @return The symmetricDifference of this and B in the form of a new MySet
	 */
	public MySet symmetricDifference(MySet B) {
		MySet temp1 = complement(B);
		MySet temp2 = B.complement(this);
		MySet temp = temp2.union(temp1);
		return temp;
	}
	/**
	 * Gives the union of this set and the given input set
	 * @param B the input set that will union with this set
	 * @return The union of this and B in the form of a new MySet
	 */
	public MySet union(MySet B) {
		MySet temp = this.clone();
		for (int i = 0; i < B.size(); i++) {
			temp.add(B.elementAt(i));
		}	
		return temp;
	}
	/**
	 * Represent the Set in the form of a String
	 * @return the string representation of the set
	 */
	@Override
	public String toString() {
		return super.toString();	
	}
	

}
