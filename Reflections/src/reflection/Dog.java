package reflection;

public class Dog extends Animal {
	
	private String name;
	private String breed;
	private String color;
	private int age;
	
	public Dog(String name, String breed, String color, int age) {
		this.setName(name);
		this.setBreed(breed);
		this.setColor(color);
		this.setAge(age);
	}
	
	public void talk() {
		System.out.println("Bark");
	}
	
	public void somethingHidden() {
		System.out.println("How did u get this");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
