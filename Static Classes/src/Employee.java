import java.io.Serializable;
import java.util.Scanner;
import java.util.*;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String occupation;
	private int age;
	private float salary, type;
	
	private static enum CLASS_TYPES {
		
		Manager(0),
		Employee(1);
		
		public int type;
		
		CLASS_TYPES(int type) {
			this.type = type;
		}
	}
	
	private class EmployeeList {
		
	}
	
	public Employee(String name, String occupation, int age, float salary, float type) {
		this.name = name;
		this.occupation = occupation;
		this.age = age;
		this.salary = salary;
		this.type = type;
	}
	
	private void sortEmployees(Employee[] employees, int response) {
		sortEmployees(employees, 0, employees.length - 1, response);
	}
	
	private void sortEmployees(Employee[] employees, int left, int right, int response) {
		
		if(left >= right)
			return;
		
		if(response == 1) {
			
			int pivot = employees[(left + right)/2].age;
			
			int index = partitionAge(employees, left, right, pivot);
			
			sortEmployees(employees, left, index - 1, response);
			sortEmployees(employees, index, right, response);
			
		} else {
			
			float pivot = employees[(left + right)/2].salary;
			
			int index = partitionSalary(employees, left, right, pivot);
			
			sortEmployees(employees, left, index - 1, (int)response);
			sortEmployees(employees, index, right, (int)response);
		}
			
		
		
	}
	
	private int partitionAge(Employee[] employees, int left, int right, int pivot) {
		
		while(employees[left].age < pivot) {
			left++;
		}
		
		while(employees[right].age > pivot) {
			right--;
		}
		
		if(left <= right) {
			swapEmployees(employees, left, right);
			left++;
			right--;
		}
		
		return left;
		
	}
	
	private int partitionSalary(Employee[] employees, int left, int right, float pivot) {
		
		while(employees[left].salary < pivot) {
			left++;
		}
		
		while(employees[right].salary > pivot) {
			right--;
		}
		
		if(left <= right) {
			swapEmployees(employees, left, right);
			left++;
			right--;
		}
		
		return left;
		
	}
	
	private void swapEmployees(Employee[] employee, int left, int right) {
		
		Employee temp = employee[left];
		employee[left] = employee[right];
		employee[right] = temp;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("----------------------------");
		result.append("\nEmployee Name : " + name);
		result.append("\nEmployee Occupation : " + occupation);
		result.append("\nEmployee Age : " + age);
		result.append("\nEmployee Salary : " + salary);
		result.append("\n----------------------------\n");
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		
		Employee[] employees = {new Employee("Jason Statham", "Actor", 50, 12000f, 1),
								new Employee("Sarah Williams", "Actor", 23, 1220f, 1),
								new Employee("Nick Buckhartd", "Hexenbiest", 43, 2343f, 1),
								new Employee("Julliete Silverton", "Bubaubiest", 13, 126000f, 1),
								new Employee("Monroe", "Grimm", 83, 1223f, 1),
								new Employee("Hank", "Footballer", 53, 6776f, 1)
								
		};
		
		Employee employeeManger = new Employee("Dan Fonster", "Footballer", 34, 232334, 0);
		
		System.out.println("Would you like to sort by Age or by Salaries");
		System.out.println("Enter 1. for Age and 2. for Salary");
		
		int response = new Scanner(System.in).nextInt();
		
		switch(response) {
		
		case 1:
			System.out.println("Sorting now by Age");
			employeeManger.sortEmployees(employees, 1);
			
			break;
			
		case 2:
			System.out.println("Sorting now by Salary");
			employeeManger.sortEmployees(employees, 2);
			
			break;
			
		default:
			 System.out.println("Sorting now by Age");
			 employeeManger.sortEmployees(employees, 1);
			break;
		}
		
		for(Employee employee: employees) {
			System.out.println(employee);
		}
	}

}
