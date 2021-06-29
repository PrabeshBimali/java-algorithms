package queue;
import java.util.NoSuchElementException;
import java.util.Iterator;



public class Deque<Item> implements Iterable<Item>{
	private Node head, tail;
	private int size = 0;

	 // construct an empty deque
    public Deque() {
    	
    }
    
    private class Node{
    	Item data;
    	Node next;
    	Node prev;
    	public Node(Item value) {
    		data = value;
    		next = null;
    		prev = null;
    	}
    }

    // is the deque empty?
    public boolean isEmpty() { return head == null; }

    // return the number of items on the deque
    public int size() {return size;}

    // add the item to the front
    public void addFirst(Item item) {
    	Node newNode = new Node(item);
    	if(item == null) throw new IllegalArgumentException("Null values are not allowed");
    	if(isEmpty()) {
    		head = tail = newNode;
    	}else {
    		Node oldNode = head;
    		head = newNode;
    		head.next = oldNode;
    		oldNode.prev = head;
    	}
    	size++;
  
    }

    // add the item to the back
    public void addLast(Item item) {
    	Node newNode = new Node(item);
    	if(item == null) {
    		throw new IllegalArgumentException("Null values are not allowed");
    	}else {
    		if(isEmpty()) {
    			head = tail = newNode;
    		}else {
    			Node oldNode = tail;
    			tail = newNode;
    			oldNode.next = tail;
    			tail.prev = oldNode;
    			
    		}
    		
    		size++;
    	}
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	Item value;
    	if(isEmpty()) {
    		throw new NoSuchElementException();
    	}else {
    		value = head.data;
    		head = head.next;
    		if(head == null) {
    			head = tail = null;
    		}else{
    			head.prev = null;
    		}
    		
    		size--;
    	}
    	return value;
    }

    // remove and return the item from the back
    public Item removeLast() {
    	Item value;
    	if(isEmpty()) {
    		throw new NoSuchElementException();
    	}else {
    		value = tail.data;
    		tail = tail.prev;
    		if(tail == null) {
    			head = tail = null;
    		}else {
    			tail.next = null;
    		}
    	}
    	
    	return value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
    	return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<Item>{
    	private Node node = head;
		public boolean hasNext() {return node != null;}
		public void remove() {throw new UnsupportedOperationException();}
		
		public Item next() {
			if(node == null) {
				throw new NoSuchElementException();
			}
			Item value = node.data;
			node = node.next;
			return value;
		}
    }
    
    // unit testing (required)
    public static void main(String[] args) {
    	Deque<Integer> d = new Deque<>();
    	d.addFirst(12);
    	d.addLast(13);
    	d.addFirst(110);
    	d.addFirst(null);
    	d.removeLast();
    	for(int i : d) {
    		System.out.println(i);
    	}
    	
	}
}
