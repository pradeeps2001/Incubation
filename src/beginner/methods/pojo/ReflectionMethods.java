package beginner.methods.pojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionMethods {

	public Constructor<?> defaultConstructor(Class<?> cls) throws NoSuchMethodException, SecurityException{
		return cls.getDeclaredConstructor();
	}
	
	public Object createInstance(Constructor<?> con) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return con.newInstance();
	}
	
}
