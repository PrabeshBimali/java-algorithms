package week2;

import java.util.Iterator;


public class StackWithLinkedList<Item> implements Iterable<Item> {
	private Node first = null;
	
	private class Node{
		Item data;
		Node next;
		
		public Node(Item x) {
			data = x;
			next = null;
		}
		
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Item x) {
		Node oldFirst = first;
		first = new Node(x);
		first.data = x;
		first.next = oldFirst;
	}
	
	public Item pop(){
		Item data = first.data;
		first = first.next;
		return data;
	}
	
	/*
	 * Client needs a way to see values in stack
	 * Below is the implementation of Iterator
	 * 
	 */
	
	public Iterator<Item> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {return current != null;}
		
		public Item next(){
			Item value = current.data;
			current = current.next;
			return value;
		}
		
		
	}
	
	/*
	 * 
	 * Main method starts from here
	 * 
	 */
	
	public static void main(String[] args) {
		StackWithLinkedList<Integer> stack = new StackWithLinkedList<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(3);
		
		for(Integer i: stack) {
			System.out.println(i);
		}
	}
}



