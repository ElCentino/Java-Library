
public class Tree <T> {
	
	private Tree<T> left;
	private Tree<T> right;
	
	private int data;
	
	public T node;
	
	public Tree() {
		
	}
	
	public Tree(int data) {
		this.data = data;
	}
	
	protected void insert(int value) {
		
		if(value <= data) {
			
			if(left == null) {
				
				left = new Tree<T>(value);
				
			} else {
				
				left.insert(value);
			}
			
		} else  {
			
			if(right == null) {
				
				right = new Tree<T>(value);
				
			} else {
				
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		
		if(value == data) {
			
			return true;
			
		} else if(value < data){
			
			if(left == null) {
				return false;
				
			} else {
				return left.contains(value);
			}
			
		} else {
			
			if(right == null) {
				return false;
				
			} else {
				return right.contains(value);
			}
		}
	}
	
	protected void treverse() {
		
		if(left != null) {
			left.treverse();
		}
		
		System.out.println(data);
		
		if(right != null) {
			right.treverse();
		}
	}
	
	public void cTreverse() {
		
		if(left != null) {
			left.treverse();
		}
		
		System.out.println(data);
		
		if(right != null) {
			right.treverse();
		}
	}
	
	public Tree<T> getLeft(){
		return left;
	}
	
	public Tree<T> getRight(){
		return right;
	}
	
	public void setLeft(Tree<T> left) {
		this.left = left;
	}
	
	public void setRight(Tree<T> right) {
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	
	protected boolean checkBST(Tree<T> tree) {
		
		return checkBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	protected boolean checkBST(Tree<T> tree, int min, int max) {
		
		if(tree == null) {
			return true;
		}
		
		if(tree.getData() < min || tree.getData() > max) {
			return false;
		}
		
		
		return checkBST(tree.left, min, tree.getData() - 1) && checkBST(tree.right, tree.getData() + 1, max);
	}
}