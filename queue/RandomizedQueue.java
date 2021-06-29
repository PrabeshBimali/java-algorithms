package queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int last = 0;
	private Item[] queue;
	
	// construct an empty randomized queue
    public RandomizedQueue() {
    	queue = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return last == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
    	return last;
    }

    // add the item
    public void enqueue(Item item) {
    	if(item == null) throw new IllegalArgumentException("Null values are not allowed");
		if( last == queue.length) resize(2*queue.length);
		queue[last++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
    	if(isEmpty()) throw new NoSuchElementException();
    	int random = StdRandom.uniform(0, last);
    	Item value = queue[random];
    	queue[random] = queue[last-1];
    	queue[--last] = null;
    	if(last>0 && last==(queue.length)/4) resize(queue.length/2);
    	return value;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if(isEmpty()) throw new NoSuchElementException();
    	return queue[StdRandom.uniform(0, last)];
    }
    
    private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];
		for(int i =0; i< last; i++) {
			copy[i] = queue[i];
		}
		
		queue = copy;
	}

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    	return new QueueIterator();
    }
    
    private class QueueIterator implements Iterator<Item>{
		private int i = -1;
		private int random;
		private Item tmp;
		public boolean hasNext() {
			i++;
			return i<last; 
		}
		public void remove() { throw new UnsupportedOperationException();}
		public Item next() {
			if(i==last) throw new NoSuchElementException();
			random = StdRandom.uniform(i, last);
			tmp = queue[i];
			queue[i] = queue[random];
			queue[random] = tmp;
			return queue[i];
		}
	}

    // unit testing (required)
    public static void main(String[] args) {
    	RandomizedQueue<String> r = new RandomizedQueue<>();
    	r.enqueue("ok");
    	r.enqueue("a");
    	r.enqueue("b");
    	r.enqueue("c");
    	//System.out.println(r.dequeue());
    	//System.out.println(r.dequeue());
    	//System.out.println(r.dequeue());
    	//System.out.println(r.dequeue());
    	//System.out.println(r.sample());
    	
    	for(String s: r) {
    		System.out.println(s);
    	}
    }
 }
