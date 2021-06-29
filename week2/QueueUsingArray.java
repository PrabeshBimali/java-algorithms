package week2;

import java.util.Iterator;

public class QueueUsingArray<Item> implements Iterable<Item> {
	private int first=0;
	private int last=0;
	Item[] queue;
	
	public boolean isEmpty() {return last == first;}
	
	public int size() {return last-first;}
	
	public QueueUsingArray(){
		queue = (Item[]) new Object[1];
	}
	
	public void enqueue(Item item) {
		if( first > 0 && last == queue.length) {
			for(int i=first; i<last; i++) {
				queue[i-first] = queue[i];
				queue[i] = null;
				last--;
			}
			
			first=0;
		}  
		else if( last == queue.length) resize(2*queue.length);
		queue[last++] = item;
	}
	
	public Item deque() {
		Item item = queue[first];
		queue[first] = null;
		first++;
		if(last>0 && last==(queue.length)/4) resize(queue.length/2);
		return item;
	}
	
	public void resize(int size) {
		Item[] copy = (Item[]) new Object[size];
		for(int i =first; i< last; i++) {
			copy[i-first] = queue[i];
		}
		
		queue = copy;
	}
	
	
	/*
	 * 
	 * Implementation of Iterator
	 * 
	 */
	public Iterator<Item> iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		private int i = first;
		public boolean hasNext() { return i<last; }
		public Item next() {
			return queue[i++];
		}
	}
	
	/*
	 * Main method for testing
	 * 
	 */
	
	
	public static void main(String[] args) {
		QueueUsingArray<String> q = new QueueUsingArray<String>();
		q.enqueue("p");
		q.enqueue("r");
		q.enqueue("b");
		System.out.println(q.deque());
		System.out.println(q.deque());
		System.out.println(q.deque());
	}
}
