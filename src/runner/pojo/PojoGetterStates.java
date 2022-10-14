package runner.pojo;

import java.util.logging.Logger;

import beginner.methods.pojo.PojoClass2;

public class PojoGetterStates {

	private static final Logger logger = Logger.getLogger(PojoGetterStates.class.getName());

	public static void main(String[] args) {

		PojoClass2 obj = new PojoClass2();

		obj.setName("Pradeep");
		obj.setAge(21);

		logger.info("Name : " + obj.getName());
		logger.info("Age : " + obj.getAge());

	}

}
