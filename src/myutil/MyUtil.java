package myutil;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.TimeZone;

public class MyUtil {

	public static void checkNull(Object input) throws CustomException {
		if (Objects.isNull(input)) {
			throw new CustomException("Input is null. Enter a valid input !");
		}
	}

	public static void checkInBound(int index1, int index2) throws CustomException {
		if (index1 < 0 || index1 > index2) {
			throw new CustomException("String Index is out of bound.\nEnter a valid input !");
		}
	}

	public static void checkInBound(StringBuilder inputSb, int index1, int index2) throws CustomException {
		if (index1 < 0 || index2 > inputSb.length()) {
			throw new CustomException("String Index is out of bound.\nEnter a valid input !");
		}
	}

	public static void checkInBound(List<?> input, int index1, int index2) throws CustomException {
		if (index1 < 0 || index2 > input.size()) {
			throw new CustomException("Index is out of bound.\nEnter a valid input !");
		}
	}
		
	public static void checkTimeZone(String input) throws CustomException {
		for (String str : TimeZone.getAvailableIDs()) {
		      if (!(str != null && str.equals(input))) {
		        throw new CustomException("Enter a valid Zone ID");
		      }
		}
	}
	
	public static int checkInt(Scanner scan) {
		boolean condition = true;
		int option = 0;
		while (condition) {
			if (scan.hasNextInt()) {
				option = scan.nextInt();
				scan.nextLine();
				if (option < 0) {
					System.out.println("Enter a positive integer");
				} else {
					condition = false;
				}
			} else {
				System.out.println("Enter a valid integer !");
				scan.next();
			}
		}
		return option;
	}

	public static String[] getStrInput(Scanner scan, int number) {
		String[] input = new String[number];
		for (int i = 0; i < number; i++) {
			System.out.println("Enter String "+ (i+1));
			input[i] = scan.nextLine();
		}
		return input;
	}

	public static int[] getIntInput(Scanner scan, int number) {
		int[] input = new int[number];
		for (int i = 0; i < number; i++) {
			input[i] = scan.nextInt();
		}
		return input;
	}

	public static Double[] getDoubleInput(Scanner scan, int number) {
		Double[] input = new Double[number];
		for (int i = 0; i < number; i++) {
			input[i] = scan.nextDouble();
		}
		return input;
	}

	public static Long[] getLongInput(Scanner scan, int number) {
		Long[] input = new Long[number];
		for (int i = 0; i < number; i++) {
			input[i] = scan.nextLong();
		}
		return input;
	}
	
	public static String directoryPutFile(String directory, String file) {
		String delimiter = "/";
		return directory.concat(delimiter).concat(file);
	}
}
