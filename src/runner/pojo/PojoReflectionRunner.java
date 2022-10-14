package runner.pojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import beginner.methods.pojo.ReflectionMethods;

public class PojoReflectionRunner {

	private static final Logger logger = Logger.getLogger(PojoReflectionRunner.class.getName());
	
	public static void main(String[] args) {

		ReflectionMethods helperObj = new ReflectionMethods();
		String name = "Pradeep";
		
		try {
			Class<?> cls = Class.forName("beginner.methods.pojo.PojoClass3");
			
			Constructor<?> constructor1 = helperObj.defaultConstructor(cls);
			Constructor<?> constructor2 = cls.getDeclaredConstructor(String.class, int.class);
			
			Object obj1 = helperObj.createInstance(constructor1);
			Method meth = cls.getDeclaredMethod("setPersonName", String.class);
			meth.invoke(obj1, name);
			
			Method meth2 = cls.getDeclaredMethod("getPersonName");
			logger.info(meth2.invoke(obj1).toString());
			
			Object obj2 = constructor2.newInstance("Pradeep",21);
			Method meth3 = cls.getDeclaredMethod("getPersonName");
			Method meth4 = cls.getDeclaredMethod("getAge");

			logger.info(meth3.invoke(obj2).toString()); // name
			logger.info(meth4.invoke(obj2).toString()); // age
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception Occured", e);
		}
	}
}