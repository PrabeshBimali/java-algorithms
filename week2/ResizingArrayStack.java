package week2;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private int n = 0;
	Item[] stack;
	
	public boolean isEmpty() { return n == 0; }
	
	public ResizingArrayStack() {
		stack = (Item[]) new Object[1];
	}
	
	public void push(Item item) {
		if( n == stack.length) resize(2*stack.length);
		stack[n++] = item;
	}
	
	public Item pop() {
		Item item = stack[--n];
		stack[n] = null;
		if(n>0 && n==(stack.length)/4) resize(stack.length/2); 
		return item;
	}
	
	public Item peek() {
		return stack[n-1];
	}
	
	public void resize(int size) {
		Item[] copy = (Item[]) new Object[size];
		for(int i =0; i< n; i++) {
			copy[i] = stack[i];
		}
		
		stack = copy;
	}
	
	/*
	 * Iterator is implemented below
	 * 
	 */
	
	public Iterator<Item> iterator(){
		return new ArrayStackIterator();
	}
	
	private class ArrayStackIterator implements Iterator<Item>{
		private int i = n;
		public boolean hasNext() {return i>0;}
		
		public Item next() {
			return stack[--i];
		}
		
	}
	
	/*
	 * 
	 * Main method starts here
	 * 
	 */
	
	public static void main(String[] args) {
		ResizingArrayStack<Integer> s = new ResizingArrayStack<Integer>();
		s.push(2);
		s.push(3);
		s.push(100);
		for(Integer i: s) {
			System.out.println();
		}
	}
}
