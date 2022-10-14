package runner.pojo;

import java.util.logging.Logger;

import beginner.methods.pojo.PojoClass1;

public class PojoPrintStates {

	private static final Logger logger = Logger.getLogger(PojoPrintStates.class.getName());
	
	public static void main(String[] args) {
		
		PojoClass1 obj = new PojoClass1("Pradeep",21);
		logger.info(obj.toString());
	}
}
