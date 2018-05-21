
//public class Practice {
//	
//	public static PeopleManager actingClass;
//	
//	public static void main(String[] args) {
//		
//		actingClass = new PeopleManager(new People("John Griffo", 50, "Black", "Actor"));
//		
//		People[] morePeople = new People[3];
//		morePeople[0] = new People("Catherine Snow", 31, "White", "Scientist");
//		morePeople[1] = new People("Harrison Wells", 52, "White", "Scientist");
//		morePeople[2] = new People("Trixie", 28, "Latina", "Inter-Galatic Guardian");
//		
//		for(People x: morePeople) {
//			actingClass.insert(x);
//		}
//		
//		People[] moremorePeople = {
//				new People("Diggie", 35, "Black", "Soldier"),
//				new People("Oliver Queen", 34, "White", "Mayor"),
//				new People("Thea Queen", 27, "White", "Speedy")
//		};
//		
//		for(People x: moremorePeople) {
//			actingClass.insert(x);
//		}
//		
//		
//		actingClass.insert(new People("Sandra Hickens", 95, "Black", "Lecturer"));
//		actingClass.insert(new People("Sandra Hickens", 65, "Black", "Lecturer"));
//		actingClass.insert(new People("Hannah Hannah", 32, "White", "Student"));
//		
//		actingClass.treverse();
//		
//		System.out.println(actingClass.checkBST(actingClass));
//	}
//}




public class Practice {
	
	public static void main(String[] args) {
		
		TwoQueueStack<String> lesson = new TwoQueueStack<>();
		lesson.enqueue("Hello");
		lesson.enqueue("People");
		lesson.enqueue("How");
		lesson.enqueue("Are");
		lesson.enqueue("You"); 
		
		System.out.println(lesson.peek());
		System.out.println(lesson.dequeue());
		System.out.println(lesson.peek());
		
		while(TwoQueueStack.count > 0) {
			System.out.println(lesson.dequeue());
		}
	}
}



//public class Practice {
//	
//	public static void main(String[] args) {
//		
//		Queue<Integer> numbers = new Queue<Integer>();
//		
//		for(int i = 1; i < 40; i++) {
//			numbers.add(i);
//		}
//		
//		Stack<String> list = new Stack<String>();
//		
//		String[] people = {"Harry", "Barry", "Sally", "Garry", "Terry", "Cherie", "Dearie"};
//		
//		for(String human: people) {
//			list.push(human);
//		}
//		
//		
////		list.print();
////		
////		list.pop();
////		System.out.println();
////		list.print();
//		
//		Stack<People> persons = new Stack<People>();
//		persons.push(new People("Barry Allen", 28, "White", "The Flash"));
//		persons.push(new People("Iris West", 29, "Black", "Reporter"));
//		persons.push(new People("Joe West", 49, "Black", "Detective"));
//		persons.push(new People("Cisco Romone", 28, "Latino", "Data Scientist"));
//		
//		People[] morePeople = new People[3];
//		morePeople[0] = new People("Catherine Snow", 32, "White", "Scientist");
//		morePeople[1] = new People("Harrison Wells", 52, "White", "Scientist");
//		morePeople[2] = new People("Trixie", 28, "Latina", "Inter-Galatic Guardian");
//		
//		People[] moremorePeople = {
//				new People("Diggie", 35, "Black", "Soldier"),
//				new People("Oliver Queen", 34, "White", "Mayor"),
//				new People("Thea Queen", 27, "White", "Speedy")
//		};
//		
////		persons.print();
////		
////		System.out.println("\nPerson at top is " + persons.peek());
////		
////		persons.pop();
////		
////		System.out.println("\nPerson at top is " + persons.peek() + "\n");
////		
////		persons.print();
////		
////		System.out.println();
////		
////		for(People person: morePeople) {
////			persons.push(person);
////		}
////		
////		for(People person: moremorePeople) {
////			persons.push(person);
////		}
////		
////		persons.print();
//		
//	}
//}