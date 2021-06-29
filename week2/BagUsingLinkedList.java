package week2;
import java.util.Iterator;
public class BagUsingLinkedList<Item> implements Iterable<Item>{
	private Node first;
	private class Node{
		Item data;
		Node next;
		public Node(Item value) {
			data = value;
			next = null;
		}
	}
	
	public void add(Item value) {
		Node oldFirst = first;
		first = new Node(value);
		first.next = oldFirst;
	}
	
	public Iterator<Item> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {return current != null;}
		public Item next() {
			Item item = current.data;
			current = current.next;
			return item;
		}
	}
	
	/*
	 * Main Method
	 * For testing purpose only
	 */
	
	public static void main(String[] args) {
		BagUsingLinkedList<Integer> bag = new BagUsingLinkedList<>();
		bag.add(1);
		bag.add(2);
		bag.add(3);
		
		for (int i: bag) {
			System.out.println(i);
		}
	}
}
