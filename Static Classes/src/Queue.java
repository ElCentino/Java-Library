public class Queue <T> {
	
	private class Node {
		
		private T data;
		private Node next;
		
		private Node(T data) {
			this.data = data;
		}
	}
	
	private Node head;  // remove from the head
	private Node tail;	// add things here
	
	public boolean isEmpty() {
		
		return head == null;
	}
	
	public T peek() {
		
		return head.data;
	}
	
	public void add(T data) {
		
		Node node = new Node(data);
		
		if(tail != null) {
			tail.next = node;
		}
		
		tail = node;
		
		if(head == null) {
			head = node;
		}
	}
	
	public T remove() {
		
		T data = head.data;
		head = head.next;
		
		if(head == null) {
			tail = null;
		}
		
		return data;	
	}
	
	public void print() {
		
		Node temp = head;
		
		while(temp.next != null) {
			
			System.out.println(temp.data);	
			
			temp = temp.next;
			
		}
		
		System.out.println(tail.data);
	}
}
