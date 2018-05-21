package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflections {
	
	static {
		
		Class<Dog> dogClass = Dog.class;
		
		int modifier = dogClass.getModifiers();
		
		System.out.println(dogClass.getSuperclass().getSimpleName());
		
		Method[] methods = dogClass.getMethods();
		
		int getterCount = 0;
		int setterCount = 0;
		
		for(Method method: methods) {
			
			if(method.getName().startsWith("get")) {
				System.out.println("Getter Method");
				System.out.println(method.getName());
				getterCount++;
			} else if(method.getName().startsWith("set")) {
				System.out.println("Setter Method");
				setterCount++;
			}
			
			Class[] parameters = method.getParameterTypes();
			
			for(Class parameter: parameters) {
				System.out.println("Parameter for : " + method.getName() + " is : " + parameter.getSimpleName());
				
				System.out.println("Type for : " + method.getName() + " is : " + parameter.getSimpleName().toString());
			}
			
		}
		
		Constructor<?> dogConstructor = null;
		Object dogObject = null;
		
		try {
			dogConstructor = dogClass.getConstructor(String.class, String.class, String.class, int.class);
			
			dogObject = dogClass.getConstructor(String.class, String.class, String.class, int.class).newInstance("Stefan", "German Shepard", "Brown", 3);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("Getter Count : " + getterCount + "\nSetter Count : " + setterCount);
		
		
		
		
	}
	
	public Reflections() {
		
	}
}
