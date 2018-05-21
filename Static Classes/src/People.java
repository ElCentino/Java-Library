
public class People {
	
	private String name;
	private String color;
	private String occupation;
	private int age;
	
	public People(String name, int age, String color, String occupation) {
		
		this.name = name;
		this.age = age;
		this.color = color;
		this.occupation = occupation;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public String toString() {
		
		String info = "Name : " + name + ", "
				+ "Age : " + age + ", "
				+ "Complexion : " + color + ", "
				+ "Occupation : " + occupation;
		
		return info;
	}
}
