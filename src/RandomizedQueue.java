import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int n;
	private Item[] rq;
	

	public RandomizedQueue() {
		n = 0;
		rq = (Item[]) new Object[2];
		// construct an empty randomized queue
	}
	public boolean isEmpty() {
		
		return n == 0;
		// is the randomized queue empty?
	}
	public int size()   {
		return n;
		// return the number of items on the randomized queue
	}
	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		if (n==rq.length) {
			Item[] temp = (Item[]) new Object[rq.length*2];
			for (int i = 0; i < rq.length;i++) {
				temp[i] = rq[i];
			}
			rq = temp;
		}
		rq[n++] = item;

	}
	public Item dequeue() {
		if (isEmpty()) {
			 throw new NoSuchElementException("Queue underflow");
		 }
		int random = StdRandom.uniform(n);
		//System.out.println(random);
		Item item = rq[random];
		//System.out.println(n-1);
		rq[random] = rq[n-1];
		rq[n-1] = null;
		n--;
		
		if (n > 0 && (n-1) == rq.length/4) {
			Item[] temp = (Item[]) new Object[rq.length/2];
			for (int i = 0; i < n;i++) {
				temp[i] = rq[i];
			}
			rq = temp;
		}
        
		
		return item;
	}
	public Item sample() {
		if (isEmpty()) {
			 throw new NoSuchElementException("Queue underflow");
		 }
		int random = StdRandom.uniform(n);
		return rq[random];
		// return a random item (but do not remove it)
	}
	public Iterator<Item> iterator(){
		return new Iterator<Item>() {
			private int i = 0 ;
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (i < n);
			}

			public Item next() {
				if (i >= n) {
					throw new NoSuchElementException();
				}
				int random = StdRandom.uniform(n-i);
				Item temp = rq[random];
				rq[random] = rq[n-1-i];
				rq[n-1-i] = temp;
				i++;
				return temp;
			}
		};
		// return an independent iterator over items in random order
	}
	
	/*
	public static void main(String[] args) {  
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.enqueue(1);
		rq.enqueue(2);
		rq.enqueue(3);
		rq.enqueue(4);
		rq.dequeue();
		rq.dequeue();
		rq.dequeue();
		rq.dequeue();
		
	}
	*/
}
