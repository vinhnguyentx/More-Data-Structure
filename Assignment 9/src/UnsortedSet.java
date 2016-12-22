/*  Student information for assignment:
 *
 *  On <MY|OUR> honor, <NAME1> and <NAME2), this programming assignment is <MY|OUR> own work
 *  and <I|WE> have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Section number:
 *  
 *  Student 2 
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Section number:
 *  
 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {
	
	private ArrayList<E> myCon;
	
	/**
     * create an empty UnsortedSet
     * pre: none
     * post: an empty UnsortedSet
     */
	public UnsortedSet() {
		myCon = new ArrayList<E> ();
	}
	
//	public UnsortedSet(ISet<E> other) {
//		this();
//		
//		assert other != null : "Violation of precondition: other != null";
//		
//		Iterator<E> it = other.iterator();
//		
//    	while (it.hasNext()){
//    		myCon.add(it.next());
//    		size ++;
//    	}
//	}

	/**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
	//O(N)
	public boolean add(E item) {
		assert item != null : "Violation of precondition: item != null";
		
		if (!this.contains(item)) {
    		myCon.add(item);
    		return true;
    	}
		return false;
	}

	
	
	/**
     * A union operation. Add all items of otherSet that are not already present in this set
     * to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, false otherwise.
     */
	//O(N^2)
   public boolean addAll(ISet<E> otherSet) {
	   assert otherSet != null : "Violation of precondition: otherSet != null";
	   
	   boolean result = false;
	   
	   for (E elem : otherSet) {
		   if (!this.contains(elem)) {
			   myCon.add(elem);
			   result = true;
		   }
	   }
	   return result;
   }
   

	/**
    * Make this set empty.
    * <br>pre: none
    * <br>post: size() = 0
    */
   //O(N)
   public void clear() {
	   myCon.clear();
   }
   

	/**
    * Create a new set that is the difference of this set and otherSet. Return an ISet of 
    * elements that are in this Set but not in otherSet. Also called
    * the relative complement. 
    * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z] then
    * A.difference(B) would return an ISet with elements [X, Y] while
    * B.difference(A) would return an ISet with elements [W]. 
    * <br>pre: otherSet != null
    * <br>post: returns a set that is the difference of this set and otherSet.
    * Neither this set or otherSet are altered as a result of this operation.
    * <br> pre: otherSet != null
    * @param otherSet != null
    * @return a set that is the difference of this set and otherSet
    */
   //O(N^2)
   public ISet<E> difference(ISet<E> otherSet) {
	   assert otherSet != null : "Violation of precondition: otherSet != null";
	   
	   ISet<E> result = new UnsortedSet<E> ();
	   
	   for (E elem : myCon) {
		   if (!otherSet.contains(elem)) {
			   result.add(elem);
		   }
	   }
	   return result;
   }
   
   
	/**
    * create a new set that is the intersection of this set and otherSet.
    * <br>pre: otherSet != null<br>
    * <br>post: returns a set that is the intersection of this set and otherSet.
    * Neither this set or otherSet are altered as a result of this operation.
    * <br> pre: otherSet != null
    * @param otherSet != null
    * @return a set that is the intersection of this set and otherSet
    */
   //O(N^2)
   public ISet<E> intersection(ISet<E> otherSet) {
	   assert otherSet != null : "Violation of precondition: otherSet != null";
	   
	   ISet<E> result = new UnsortedSet<E> ();
	   
	   for (E elem : myCon) {
		   if (otherSet.contains(elem)) {
			   result.add(elem);
		   }
	   }
	   return result;
   }
   

	/**
    * Return an Iterator object for the elements of this set.
    * pre: none
    * @return an Iterator object for the elements of this set
    */
	//O(1)
	public Iterator<E> iterator() {
		Iterator<E> it = myCon.iterator();
		return it;
	}
   
   
	/**
    * Remove the specified item from this set if it is present.
    * pre: item != null
    * @param item the item to remove from the set. item may not equal null.
    * @return true if this set changed as a result of this operation, false otherwise
    */
	//O(N)
	public boolean remove(E item) {
		assert item != null : "Violation of precondition: item != null";

		for (E elem : myCon) {
			if (elem.equals(item)) {
				myCon.remove(elem);
				return true;
			}
		}
		return false;
   }
   
   
	/**
    * Return the number of elements of this set.
    * pre: none
    * @return the number of items in this set
    */
	//O(N)
   public int size() {
	   return myCon.size();
   }
   
   
	/**
    * Create a new set that is the union of this set and otherSet.
    * <br>pre: otherSet != null
    * <br>post: returns a set that is the union of this set and otherSet.
    * Neither this set or otherSet are altered as a result of this operation.
    * <br> pre: otherSet != null
    * @param otherSet != null
    * @return a set that is the union of this set and otherSet
    */
   //O(N^2)
   public ISet<E> union(ISet<E> otherSet) {
	   assert otherSet != null : "Violation of precondition: otherSet != null";

	   ISet<E> result = new UnsortedSet<E> ();
	   
	   for (E elem : myCon) {
		   result.add(elem);
	   }
	   
	   for (E elem : otherSet) {
		   if (!result.contains(elem)) {
			   result.add(elem);
		   }
	   }
	   return result;
   }
}