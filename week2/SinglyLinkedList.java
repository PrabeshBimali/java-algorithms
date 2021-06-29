package week2;

public class SinglyLinkedList {
	Node head;
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	/* 
	 * 
	 * Main Method from here
	 * 
	 */
	
	public static void main(String[] args) {
		SinglyLinkedList linked = new SinglyLinkedList();
		linked.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		linked.head.next = second;
		second.next = third;
		
		Node n = linked.head;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
		
	}
}
