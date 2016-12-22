/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:
 *  email address:
 *  UTEID:
 *  Section 5 digit ID: 
 *  Grader name:
 *  Number of slip days used on this assignment:
 */

import java.util.Iterator;

public class LinkedList<E> implements IList<E> {
    
	private DoubleListNode<E> first;
	private DoubleListNode<E> last;
	private int size;
	
	//O(1)
	public LinkedList() {
		first = new DoubleListNode<E> ();//(first, null, first);
		size = 0;
	}
    
    private class LLIterator implements Iterator<E>{
    	
    	private DoubleListNode<E> nextNode;
    	private boolean removable;
    	
    	//O(1)
    	private LLIterator() {
    		nextNode = first.getNext();
    		removable = false;
    	}
    	
    	//O(1)
    	public boolean hasNext() {
    		return nextNode != first;
    	}

    	//O(1)
    	public E next() {
    		if (!hasNext())
    			throw new IllegalArgumentException("No more element.");
    		
    		E result = nextNode.getData();
    		nextNode = nextNode.getNext();
    		removable = true;
    		return result;
    	}

    	//O(1)
    	public void remove() {
    		if (!removable)
    			throw new IllegalArgumentException("Cannot remove.");
    		removable = false;
    		nextNode.getPrev().getPrev().setNext(nextNode);
    		nextNode.setPrev(nextNode.getPrev().getPrev());
    		size --;
    	}
    }
    
    //Add an item to the end of the list
    //pre: item != null
    //pos: post: size() = old size() + 1
    //O(1)
	public void add(E item){
		if (item == null)
			throw new IllegalArgumentException("Cannot add null item.");
		DoubleListNode<E> newNode = new DoubleListNode<E>(null, item, first);
		
		if (size == 0) {
			first.setNext(newNode);
			first.setPrev(newNode);
			newNode.setPrev(first);
		} else {
			first.getPrev().setNext(newNode);
			first.setPrev(newNode);
			newNode.setPrev(first.getPrev());
		}
		size ++;
	}

	//Insert an item to a specified position of the list
    //pre: item != null, 0 <= pos <= size
    //pos: post: size() = old size() + 1
	//O(N)
	public void insert(int pos, E item){
		if (item == null)
			throw new IllegalArgumentException("Cannot insert null item.");
		if (pos < 0 || pos > size)
			throw new IllegalArgumentException("Position is out of bound.");
		if (pos == 0) {
			addFirst(item);
		} else if (pos == size) {
			add(item);
		} else {
			DoubleListNode<E> temp = getNode(pos);
			DoubleListNode<E> newNode = new DoubleListNode<E>(temp.getPrev(), item, temp);
			temp.getPrev().setNext(newNode);
			temp.setPrev(newNode);
		}
		size ++;		//inside or outside {   } ??????????
	}
		//Get Node at a specified position
		//pre: 0 <= pos <= size
		//pos: return Node at pos
		//O(N)
		public DoubleListNode<E> getNode(int pos) {
			if (pos < 0 || pos > size)
				throw new IllegalArgumentException("Position is out of bound.");
			int halfSize = size/2;
			DoubleListNode<E> temp = first;
			if (pos >= halfSize) {
				for (int index = 0; index < (size - pos); index ++) {
					temp = temp.getPrev();
				}
			} else {
				for (int index = 0; index <= pos; index ++) {
					temp = temp.getNext();
				}
			}
			return temp;
		}

	//Change the data at the specified position in the list.
	//The old data at that position is returned.
	//pre: 0 <= pos < size() 
	//post: get(pos) = item, return the old get(pos)
	//O(N)
	public E set(int pos, E item){
		if (pos < 0 || pos > size)
			throw new IllegalArgumentException("Position is out of bound.");
		DoubleListNode<E> temp = getNode(pos);
		E data = temp.getData();
		temp.setData(item);
		return data;
	}

	//Get an element from the list. 
	//pre: 0 <= pos < size() 
	//post: return the item at pos
	//O(N)
	public E get(int pos){
		return getNode(pos).getData();
	}

	//Remove an element in the list based on position. 
	//pre: 0 <= pos < size() 
	//post: size() = old size() - 1, all elements of list
	//with a positon > pos have a position = old position - 1
	//O(N)
	public E remove(int pos){
		if (pos < 0 || pos > size)
			throw new IllegalArgumentException("Position is out of bound.");
		E element = first.getNext().getData();
		if (pos == 0) {
			element = removeFirst();
		} else if (pos == size - 1) {
			element = removeLast();
		} else {
			DoubleListNode<E> temp = getNode(pos);
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			element = temp.getData();
		}
		size --;		//in or outside { }
		return element;
	}

	//Remove the first occurrence of obj in this list
	//Return true if this list changed as a result of this call, false otherwise. 
	//pre: none 
	//post: if obj is in this list the first occurence has been removed and size() = old size() - 1.
	//If obj is not present the list is not altered in any way.
	//O(N)
	public boolean remove(E obj){
		boolean result = false;
		DoubleListNode<E> nodeToFind = getNode(obj);
		if (nodeToFind == null) {
			result = false;
		} else {
			nodeToFind.getNext().setPrev(nodeToFind.getPrev());
			nodeToFind.getPrev().setNext(nodeToFind.getNext());
			size --;
			result = true;
		}
		return result;
	}
		
		//Get Node that has data equals obj
		//pre: obj != null
		//pos: return the Node that has data equals obj
		//O(N)
		public DoubleListNode<E> getNode (E obj) {
			if (obj == null)
				throw new IllegalArgumentException("Item cannot be null.");
			if (first.getPrev().getData().equals(obj)) {
				return first.getPrev();
			} else {
				DoubleListNode<E> temp = first.getNext();
				while (!temp.getData().equals(obj) && temp != first) {
					temp = temp.getNext();
				}
				if (temp == first) {		// ??????
					return null;			// ??????
				}
				return temp;
			}
		}

	
	//Return a sublist of elements in this list from start inclusive to stop exclusive.
	//This list is not changed as a result of this call. 
	//pre: 0 <= start < size(), start <= stop <= size() 
	//post: return a list whose size is stop - start and contains the elements 
	//at positions start through stop - 1 in this list.
	//O(N)
	public IList<E> getSubList(int start, int stop){
		if (start < 0 || start > size || stop < start || stop > size)
			throw new IllegalArgumentException("Wrong input.");
		IList<E> result = new LinkedList<E> ();
		DoubleListNode<E> node = getNode(start);
		result.add(node.getData());
		
		for (int i = 1; i < (stop - start); i ++) {
			node = node.getNext();
			result.add(node.getData());
		}
		return result;
	}

	
	//Return the size of this list. In other words the number of elements in this list. 
	//pre: none 
	//post: return the number of items in this list
	//O(1)
	public int size(){
		return size;
	}

	
	//Find the position of an element in the list. 
	//pre: item != null 
	//post: return the index of the first element equal to item or -1 if item is not present
	//O(N)
	public int indexOf(E item){
		return indexOf(item, 0);
	}

	
	//find the position of an element in the list starting at a specified position. 
	//pre: 0 <= pos < size(), item != null 
	//post: return the index of the first element equal to item starting at pos
	//or -1 if item is not present from position pos onward
	//O(N)
	public int indexOf(E item, int pos){
		if (item == null) 
			throw new IllegalArgumentException("Item cannot be null");
		int position = pos;
		DoubleListNode<E> temp = getNode(pos);
		while (temp != first && !temp.getData().equals(item)) {
			temp = temp.getNext();
			position ++;
		}
		if (temp == first) {
			return -1;
		} else {
			return position;
		}
	}

	
	//return the list to an empty state. 
	//pre: none 
	//post: size() = 0
	//O(1)
	public void makeEmpty(){
		first = new DoubleListNode<E>();
		last = new DoubleListNode<E>();
		first.setNext(last);
		first.setPrev(last);
		size = 0;
	}

	
	//return an Iterator for this list. 
	//pre: none 
	//post: return an Iterator object for this List
	//O(1)
	public Iterator<E> iterator() {
		return new LLIterator();
	}
	
	
	//Remove all elements in this list from start inclusive to stop exclusive. 
	//pre: 0 <= start < size(), start <= stop <= size() 
	//post: size() = old size() - (stop - start)
	//O(N)
    public void removeRange(int start, int stop) {
    	if (start < 0 || start >= size || start > stop || stop > size)
    		throw new IllegalArgumentException("Invalid inputs.");
    	if (start == stop) {
    		
    	}
    }
	
	/**
	 * add item to the front of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
	public void addFirst(E item) {
	}


	/**
	 * add item to the end of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	public void addLast(E item) {
	}


	/**
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	public E removeFirst() {	
	    return null;
	}


	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	public E removeLast() {	
	    return null;
	}


	public String toString() {	
	    return null;
	}


	/**
	 * Check if this list is equal to another Object.
	 * Follow the contract of IList
	 * <br>pre: none
	 * @return true if other is a non null IList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 */
	public boolean equals(Object other){	
	    return true;
	}


}