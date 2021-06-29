package week2;

import java.util.Iterator;


public class QueueUsingLlinkedList<Item> implements Iterable<Item> {
	Node head, tail;
	private class Node{
		Item data;
		Node next;
		
		
		public Node(Item x) {
			data =  x;
			next = null;
		}
	}
		
		public boolean isEmpty() {return head == null;}
		
		public void enqueue(Item value) {
			Node oldTail = tail;
			tail = new Node(value);
			tail.next = null;
			if(isEmpty()) head = tail;
			else oldTail.next = tail;
		}
		
		public Item deque() {
			Item value = head.data;
			head = head.next;
			if(isEmpty()) tail = null;
			return value;
			
		}
		
		public Iterator<Item> iterator(){
			return new LinkedListIterator();
		}
		
		private class LinkedListIterator implements Iterator<Item>{
			private Node current = head;
			public boolean hasNext() {return current != null;}
			
			public Item next(){
				Item value = current.data;
				current = current.next;
				return value;
			}
			
			
		}
		
		/*
		 * IMPLEMENTAION OF STACK Ends here
		 * MAIN method starts from here
		 * 
		 */
		
		public static void main(String[] args) {
			QueueUsingLlinkedList<Integer> queue = new QueueUsingLlinkedList<Integer>();
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(7);
			for(Integer i: queue) {
				System.out.println(i);
			}
			
		}
		
	
	
}
