package runner.enums;

import java.util.Scanner;
import java.util.logging.Logger;

import beginner.methods.enums.RainbowColors;

public class RainbowRunner {

	private static final Logger logger = Logger.getLogger(RainbowRunner.class.getName());

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		RainbowColors[] colours = RainbowColors.values();
		
		logger.info("Enter the colour : ");
		String input = scan.next();
		
		for (RainbowColors color : colours) {
			if (color.toString().equalsIgnoreCase(input)) {
				logger.info("The value of color \"" + input + "\" : " + color.getValue());
			}
		}
		scan.close();
	}

}
