
public class Doubly {
	
	static int counter = 0;
	
	private class Node {
		
		private int data;
		private Node prev;
		private Node next;
		
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	
	public Doubly() {
		
		
	}
	
	public void insert(int data) {
		
		if(head == null) {
			head = new Node(data);

			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
			Doubly.counter += 1200000;
			
			System.out.println(counter);
			
			if(counter >= Integer.MAX_VALUE)
				counter = 1;
			
		}
		
		current.next = new Node(data);
		current.next.prev = current;
		current.next = head;
	}
	
	public static void main(String[] args) {
		
		Doubly n = new Doubly();
		n.insert(50);
		n.insert(30);
		n.insert(10);
		n.insert(60);
		
		
		System.out.println(n.head.next.prev.data);
		System.out.println(n.head.next.next.prev.data);
		System.out.println(n.head.next.next.next.prev.data);
		System.out.println(n.head.prev.data);
		
	}

}
