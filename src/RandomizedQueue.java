import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	int n;
	Item[] rq;
	
	
	public RandomizedQueue() {
		n=0;
		
		
		rq = (Item[]) new Object[2];
		// construct an empty randomized queue
	}
	public boolean isEmpty() {
		
		return n==0;
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
			for (int i =0; i<rq.length;i++) {
				temp[i]=rq[i];
			}
			rq = temp;
		}
		rq[n++]=item;

	}
	public Item dequeue() {
		if (isEmpty()) {
			 throw new NoSuchElementException("Queue underflow");
		 }
		int random = StdRandom.uniform(n);
		Item item = rq[random];
		rq[random]=rq[n];
		rq[n--]= null;
		
		if (n > 0 && n == rq.length/4) {
			Item[] temp = (Item[]) new Object[rq.length/2];
			for (int i =0; i<rq.length;i++) {
				temp[i]=rq[i];
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
			int i = 0 ;
		
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return i<n;
			}

			@Override
			public Item next() {
				// TODO Auto-generated method stub
				int random = StdRandom.uniform(n-i);
				Item temp = rq[random];
				rq[random]=rq[n-1-i];
				rq[n-1-i] = temp;
				i++;
				return temp;
			}
			
		};
		// return an independent iterator over items in random order
	}
	public static void main(String[] args) {  
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.enqueue(1);
		rq.enqueue(12);
		rq.enqueue(13);
		rq.enqueue(14);
		
		rq.enqueue(15);
		
		rq.dequeue();
		
		
		Iterator<Integer> it = rq.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
