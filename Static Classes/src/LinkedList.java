
public class LinkedList {
	
	private Node head;
	
	private static class Node {
		
		private int data;
		private Node next;
		
		private Node(int data) {
			this.data = data;
		}
	}
	
	public void append(int data) {
		
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = new Node(data);
	}
	
	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int data) {
		
		if(head == null) {
			return;
		}
		
		if(head.data == data) {
			head = head.next;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			
			if(current.next.data == data) {
				current.next = current.next.next;
			}
			current = current.next;
		}
	}

	public void print() {
		Node current;
		
		if(head == null)
			return;
		else
			current = head;
		
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
		
		System.out.println(current.data);
	}
}
