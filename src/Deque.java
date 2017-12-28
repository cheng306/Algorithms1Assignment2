import java.util.Iterator;

public class Deque <Item> implements Iterable<Item>{
	public Node first;
	public Node last;
	public int n;
	
	
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
			first = node;
			last = node;
			
		}
		else {
			Node oldFirst = first;
			Node node = new Node();
			node.item=item;
			node.next = oldFirst;
			
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
			first = node;
			last = node;
		}
		else { 
			Node node = new Node();
			node.item=item;
			node.next = null;
			last.next = node;
			last = node;	
		}
		n++;
	}
	
	
	public Item removeFirst() {
		return null;
	}
	public Item removeLast() {
		return null;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(5);
	}
	
	class Node{
		private Item item;
        private Node next;
	}

}
