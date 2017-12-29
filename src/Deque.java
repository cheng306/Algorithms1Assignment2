import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque <Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int n;
	
	
	public Deque()  {
		first = null;
        last  = null;
        n = 0;
        
        
	}
	public boolean isEmpty()  {
		return (n==0);
	}
	public int size() {
		return n;
	}
	public void addFirst(Item item) {
		
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		if (first == null) {
			Node node = new Node();
			node.item=item;
			node.next = null;
			node.previous = null;
			first = node;
			last = node;
			
		}
		else {
			
		
			Node node = new Node();
			node.item=item;
			node.next = first;
			first.previous = node;
			first = node;
			
		}
		n++;
        
	}
	public void addLast(Item item) {
		
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		if (last == null) {
			Node node = new Node();
			node.item=item;
			node.next = null;
			node.previous = null;
			first = node;
			last = node;
		}
		else { 
			Node node = new Node();
			node.item=item;
			node.next = null;
			node.previous = last;
			last.next = node;
			last = node;	
		}
		n++;
	}
	
	
	public Item removeFirst() {
		 if (isEmpty()) {
			 throw new NoSuchElementException("Queue underflow");
		 }
	     Item item = first.item;
	     first = first.next;
	     n--;
	     if (isEmpty()) {
	    	 last = null;   
	     }
	     else {
	    	 first.previous = null;
	     }
	     return item;
	}
	public Item removeLast() {
		if (isEmpty()) {
			 throw new NoSuchElementException("Queue underflow");
		 }
	     Item item = last.item;
	     last = last.previous;
	     n--;
	     if (isEmpty()) {
	    	 first = null;   
	     }
	     else {
	    	 last.next = null;
	     }
	     return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}
	
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(5);
	}
	
	private class Node{
		private Item item;
        private Node next;
        private Node previous;
	}
	
	private class DequeIterator implements Iterator<Item>{
		
		Node current  = first;
		@Override
		public boolean hasNext() {
			return (current!=null);
		}

		@Override
		public Item next() {	
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

}
