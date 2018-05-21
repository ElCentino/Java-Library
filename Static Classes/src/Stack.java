
public class Stack <T> {
	
	private class Node {
		
		private T data;
		private Node next;
		
		private Node(T data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	public boolean isEmpty() {
		
		return top == null;
	}
	
	public T peek() {
		
		return top.data;
	}
	
	public void push(T data) {
		
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public T pop() {
		
		T data = top.data;
		top = top.next;
		
		return data;
	}
	
	public void print() {
		
		Node temp = top;
		
		while(temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
		System.out.println(temp.data);
	}

}
