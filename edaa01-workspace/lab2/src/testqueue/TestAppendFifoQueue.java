package testqueue;

import java.util.Iterator;
import queue.FifoQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAppendFifoQueue {

	
	@Test
	public void testEmptyQueues() {
		FifoQueue<Integer> q1 = new FifoQueue<Integer>();
		FifoQueue<Integer> q2 = new FifoQueue<Integer>();
		q1.append(q2);
		assertTrue("Listan är inte tom", q1.size() == 0);
	}
	
	@Test
	public void testAddEmpty() {
		FifoQueue<Integer> q1 = new FifoQueue<Integer>();
		FifoQueue<Integer> q2 = new FifoQueue<Integer>();
		for(int i = 1; i <= 10; i++) {
			q1.offer(i);
		}
		int bsize = q1.size();
		int forst = q1.peek();
		q1.append(q2);
		assertTrue("Storleken förändras", bsize == q1.size());
		assertTrue("Sista elementet har ändrats", forst == q1.peek());
		assertTrue("Lista 2 är inte tom efter sammanslagning", q2.size() == 0);
	}
	
	@Test
	public void testAddToEmpty() {
		FifoQueue<Integer> q1 = new FifoQueue<Integer>();
		FifoQueue<Integer> q2 = new FifoQueue<Integer>();
		for(int i = 1; i <= 10; i++) {
			q2.offer(i);
		}
		int bsize = q2.size();
		int forst = q2.peek();
		q1.append(q2);
		assertTrue("Storleken förändras", bsize == q1.size());
		assertTrue("Sista elementet har ändrats", forst == q1.peek());
		assertTrue("Lista 2 är inte tom efter sammanslagning", q2.size() == 0);
	}
	
	@Test
	public void testAdd() {
		FifoQueue<Integer> q1 = new FifoQueue<Integer>();
		FifoQueue<Integer> q2 = new FifoQueue<Integer>();
		for(int i = 1; i <= 10; i++) {
			q2.offer(i);
		}
		for(int i = 11; i <= 20; i++) {
			q1.offer(i);
		}
		q1.append(q2);
		assertTrue("Storleken är fel", q1.size() == 20);
		assertTrue("Första objektet är fel", q1.peek() == 11);
		assertTrue("Lista 2 är inte tom efter sammanslagning", q2.size() == 0);
		Iterator<Integer> itr = q1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
