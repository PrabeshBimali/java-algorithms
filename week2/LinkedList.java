package week2;

public class LinkedList {
	   private Node head;
	    /** Initialize your data structure here. */
	    
	    private class Node{
	        int val;
	        Node next;
	        Node(int val){
	            this.val = val;
	            this.next = null;
	        }
	    }
	    
	    
	    
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	        int i = 0;
	        for(Node n=head; n!=null; n=n.next){
	            if(i==index) return n.val;
	            i++;
	        }
	        
	        return -1;
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
           Node newNode = new Node(val);

	        if(head==null) {
	            head = newNode;
	        }else{
	            Node oldHead = head;
	            head = newNode;
	            head.next = oldHead;
	        }
	        
	        
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
           Node newNode = new Node(val);
	        if(head==null){
	            head = newNode;
	        }else{
	            Node n = head;
	            while(n.next!=null){
	                n = n.next;
	            }
	            n.next = newNode;
	        }
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	        int i=1;
	        Node n = head;
	        if(index==0){
	            addAtHead(val);    
	        }else{
	            while(n!=null){
	                if(i==index){
	                    Node newNode = new Node(val);
	                    Node oldNext = n.next;
	                    n.next = newNode;
	                    newNode.next=oldNext;
	                }
	                n = n.next;
	                i++;
	            }       
	        }
	        
	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	        int i=1;
	        Node n = head;
	        if(n==null && index==0)
	        	throw new NullPointerException();
	        if(index==0) {
	        	head = head.next;
	        }else {
	        	while(n!=null) {
	        		if(i==index) {
	        			if(n.next != null) {
	        				Node oldNext = n.next.next;
	        				n.next = oldNext;
	        			}
	        		}
	        		n=n.next;
	        		i++;
	        	}
	        }
	    }
	    public void printList() {
	    	Node n = head;
	    	while(n!=null) {
	    		System.out.println(n.val);
	    		n=n.next;
	    	}
	    }
	    
	    public static void main(String[] args) {
			LinkedList l = new LinkedList();
			l.addAtHead(0);
			l.addAtHead(1);
			l.addAtTail(3);
			l.addAtIndex(1, 5);
			l.deleteAtIndex(3);
			l.addAtIndex(0, 10);
			l.printList();

			
		}
}
