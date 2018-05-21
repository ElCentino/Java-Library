
public class PeopleManager extends Tree <PeopleManager>{
	
	private PeopleManager leftNode;
	private PeopleManager rightNode;
	
	public int identifier;
	
	private People person;
	
	public PeopleManager(People person) {
		
		super(person.getAge());
		
		identifier = person.getAge();
		
		this.person = person;
	}
	
	public void insert(People person) {
		
		int value = person.getAge();
		
		if(value <= identifier) {
			
			if(leftNode == null) {
				leftNode = new PeopleManager(person);
				
			} else {
				leftNode.insert(person);
			}
			
		} else {
			
			if(rightNode == null) {
				rightNode = new PeopleManager(person);
				
			} else {
				rightNode.insert(person);
			}
		}
	}
	
	public boolean contains(People person) {
		
		int value = person.getAge();
		
		if(value == identifier) {
			return true;
			
		} else if(value < identifier) {
			
			if(leftNode == null) {
				return false;
				
			} else {
				
				return leftNode.contains(person);
			}
			
		} else {
			
			if(rightNode == null) {
				return false;
				
			} else {
				
				return rightNode.contains(person);
			}
		}
	}
	
	@Override
	protected boolean checkBST(Tree<PeopleManager> node) {
		
		return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	@Override
	protected boolean checkBST(Tree<PeopleManager> node, int min, int max) {
		
		if(node == null)
			return true;
		
		if(node.getData() < min || node.getData() > max) {
			return false;
		}
		
		return checkBST(node.getLeft(), min, node.getData() - 1) && checkBST(node.getRight(), node.getData() + 1, max);
	}
	
	public PeopleManager getLeft(){
		return leftNode;
	}
	
	public PeopleManager getRight(){
		return rightNode;
	}
	
	public void treverse() {
		
		if(leftNode != null) {
			leftNode.treverse();
		}
		
		System.out.println(person);
		
		if(rightNode != null) {
			rightNode.treverse();
		}
	}

}
