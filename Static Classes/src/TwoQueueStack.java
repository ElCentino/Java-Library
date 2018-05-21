
public class TwoQueueStack <T> {
	
	private Stack<T> newStack = new Stack<T>();
	private Stack<T> oldStack = new Stack<T>();
	
	public static int count = 0;
	
	public void enqueue(T data) {
		newStack.push(data);
		count++;
	}
	
	public T peek() {
		shiftStacks();
		return oldStack.peek();
	}
	
	public boolean isEmpty() {
		return oldStack.isEmpty();
	}
	
	private void shiftStacks()
	{
		if(oldStack.isEmpty()) {
			while(!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
	}
	
	public T dequeue() {
		count--;
		shiftStacks();
		return oldStack.pop();
	}

}
