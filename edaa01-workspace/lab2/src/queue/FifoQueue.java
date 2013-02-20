package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> 
implements Queue<E> {
	private QueueNode<E> last;
	private int size;
	private ArrayList<E> list;
	public FifoQueue() {
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size; 
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	x the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E x) {
		if(last != null) {
			QueueNode<E> first;
			first = last.next; 
			last.next = new QueueNode<E>(x);
			last = last.next;
			last.next = first;
		} else {
			last = new QueueNode<E>(x);
			last.next = last;
		}
		size++;
		return true;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		E element = null;
		if(last != null) {
			QueueNode<E> first;
			if(last.next.equals(last)) {
				first = last;
				last = null;
			} else {
				first = last.next;
				last.next = first.next;
			}
			element = first.element;
			size--;
		}
		return element;
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		E element = null;
		if (last != null) {
			element = last.next.element;
		}
		return element;
	}
	
	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * 		 to this queue. The specified queue (q) is empty
	 * @param q the queue to append
	 */
	public void append(FifoQueue<E> q) {
		if (q.size() != 0) {
			if(last != null) {
				QueueNode<E> first = last.next;
				last.next = q.last.next;
				q.last.next = first;
			}
			last = q.last;
		}
		size += q.size;
		q.last = null;
		q.size = 0;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private QueueNode<E> end;
		boolean passed = false;
		
		private QueueIterator() {
			if(last != null) {
				pos = last.next;
				end = last;
			}
		}
		
		public boolean hasNext() {
			return pos != null && pos.next != null && !passed;
		}
		
		public E next() {
			if (pos.next == null || passed) {
				throw new NoSuchElementException("Next finns inte!");
			}
			QueueNode<E> temp = pos;
			pos = pos.next;
			if(temp.equals(end)) {
				passed = true;
			}
			return temp.element;
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Det får du inte göra!");
		}
	}

}
