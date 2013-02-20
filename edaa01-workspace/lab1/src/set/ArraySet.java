package set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArraySet<E> implements SimpleSet<E> {
	private ArrayList<E> set;

	/**
	 * Constructs a new empty set.
	 */
	public ArraySet() {
		set = new ArrayList<E>();
	}

	/** 
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * @param  x the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		if (!contains(x)) {
			return set.add(x);	
		}
		return false;
	}

	/** 
	 * Removes the specified element from this set if it is present. 
	 * post: 	x is removed if it was present
	 * @param 	x the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {
		return set.remove(x);
	}

	/** 
	 * Returns true if this set contains the specified element.
	 * @param 	x the element whose presence is to be tested
	 * @return	true if this set contains the specified element
	 */
	public boolean contains(Object x) {		
		return set.contains(x);
		
	}


	/** 
	 * Returns true if this set contains no elements.
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty() {		
		return set.isEmpty();
	}

	/** 
	 * Returns the number of elements in this set.
	 * @return the number of elements in this set
	 */
	public int size() {
		return set.size();
	}

	/** 
	 * Returns an iterator over the elements in this set.
	 * @return an iterator over the elements in this set
	 */
	public Iterator<E> iterator() {
		return set.iterator();
	}
	
	public boolean addAll(SimpleSet<? extends E> s) {
		Iterator<? extends E> itr = s.iterator();
		int oldSize = set.size();
		while(itr.hasNext()){
			add(itr.next());			
		}
		return oldSize != set.size();
	}
	
	public E get(int k) {
		return set.get(k);
	}
	
	public static void whatever() {
		System.out.println("Hello");
	}

}
