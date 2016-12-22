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

public abstract class AbstractSet<E> implements ISet<E> {

	/**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
//    public boolean add(E item) {
//    	assert (item != null) : "Violation of precondition: item != null";
//    	
//    	if (!this.contains(item)) {
//    		return true;
//    	}
//    	return false;
//    }
	
	
	/**
     * A union operation. Add all items of otherSet that are not already present in this set
     * to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, false otherwise.
     */
    public boolean addAll(ISet<E> otherSet) {
    	assert (otherSet != null) : "Violation of precondition: otherSet != null";
    	
    	Iterator<E> it = otherSet.iterator();
    	int newSize = this.size();
    	
    	while (it.hasNext()) {
    		if (!this.contains(it.next())) {
    			this.add(it.next());
    			newSize ++;
    		}
    	}
    	return newSize > this.size();
    }
    
    
    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear() {
    	Iterator<E> it = this.iterator();
    	
    	while (it.hasNext()) {
    		it.next();
    		it.remove();
    	}
    }
    
    
    /**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    //Code from assignment's tips
    public boolean contains(E item) {
    	assert (item != null) : "Violation of precondition: item != null";
    	
    	Iterator<E> it = this.iterator();
    	
    	while (it.hasNext()) {
    		if (it.next().equals(item)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    public boolean containsAll(ISet<E> otherSet) {
    	assert (otherSet != null) : "Violation of precondition: otherSet != null";
    	
    	Iterator<E> it = otherSet.iterator();
    	
    	while (it.hasNext()) {
    		if (!this.contains(it.next())) {
    			return false;
    		}
    	}
    	return true;
    }
    

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    @SuppressWarnings("unchecked")
//	public boolean equals(Object other) {
//    	if (other instanceof ISet) {		//check if other is a ISet
//    		if (((ISet<E>) other).containsAll(this)  
//    				&& this.containsAll((ISet<E>) other)) {
//    			return true;
//    		}
//    		return false;
//    	}
//    	return false;
//    }
    
    public boolean equals (Object other) {
    	if (!(other instanceof ISet<?>)) {
    		return false;		//if other is not ISet
    	} else {

    		if (((ISet<E>) other).size() != this.size()) {
    			return false;		//if sizes are different
    		} else {

    			Iterator<E> otherIt = ((ISet<E>) other).iterator();

    			while (otherIt.hasNext()) {
    				Iterator<E> thisIt = this.iterator();
    				Comparable<E> otherElem = (Comparable<E>) otherIt.next();
    				boolean result = false;

    				while (thisIt.hasNext()) {
    					if  (otherElem == thisIt.next()) {
    						result = true;
    					}
    				}
    				if (result == false) {	
    					return false;		//if a single element of other is not equal to any element of this set
    				}
    			}
    			return true;
    		} 
    	}
    }
    
    
	/**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     */
    public boolean remove(E item) {
    	assert (item != null) : "Violation of precondition: item != null";
    	
    	Iterator<E> it = iterator();
    	
    	while (it.hasNext()) {
    		if (item.equals(it.next())) {
    			it.remove();
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
    public int size() {
    	int size = 0;
    	Iterator<E> it = this.iterator();
    	
    	while (it.hasNext()) {
    		it.next();
    		size ++;
    	}
    	return size;
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
    public ISet<E> intersection(ISet<E> otherSet) {
    	assert (otherSet != null) : "Violation of precondition: otherSet != null";

    	ISet<E> result = this.union(otherSet);
    	Iterator<E> it = this.difference(otherSet).iterator();
    	
    	while (it.hasNext()) {
    		result.remove(it.next());
    	}
    	return result;
    }
    
    
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
}
