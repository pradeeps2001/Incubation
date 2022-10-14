package runner.enums;

import java.util.logging.Logger;

import beginner.methods.enums.SingletonEnum;

public class SingletonEnumRunner {

	private static final Logger logger = Logger.getLogger(SingletonEnumRunner.class.getName());

	public static void main(String[] args) {
		
		// both are same instance
		SingletonEnum obj = SingletonEnum.getField();
		SingletonEnum obj2 = SingletonEnum.getField();
		
		// every instance takes the last updated value
		obj.setValue(5);
		obj2.setValue(66);
		
		logger.info("Value : " + obj.getValue());
		logger.info("Value : " + obj2.getValue());
		
	}
}
