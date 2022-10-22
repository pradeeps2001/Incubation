package myutil;

import java.util.Objects;
import java.util.Scanner;

public class MyUtil {
	
	public static void checkNull(Object input) throws CustomException {
		if (Objects.isNull(input)) {
			throw new CustomException("Input is null. Enter a valid input !");
		}
	}
	
	public static void validWithdraw(double balance, double amount) throws CustomException {
		if(amount > balance) {
			throw new CustomException("Insufficient balance.");
		}
	}
	
	public static void validTransfer(double balance, double amount) throws CustomException {
		if(amount > balance) {
			throw new CustomException("Insufficient balance.");
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
	
	public static long checkLong(Scanner scan) {
		boolean condition = true;
		long option = 0;
		while (condition) {
			if (scan.hasNextLong()) {
				option = scan.nextLong();
				scan.nextLine();
				if (option < 0) {
					System.out.println("Enter a positive integer");
				} else {
					condition = false;
				}
			} else {
				System.out.println("Enter a valid long !");
				scan.next();
			}
		}
		return option;
	}
	
	public static double checkDouble(Scanner scan) {
		boolean condition = true;
		double option = 0;
		while (condition) {
			if (scan.hasNextDouble()) {
				option = scan.nextDouble();
				scan.nextLine();
				if (option < 0) {
					System.out.println("Enter a positive integer");
				} else {
					condition = false;
				}
			} else {
				System.out.println("Enter a valid long !");
				scan.next();
			}
		}
		return option;
	}
	
	public static Long[] getLongInput(Scanner scan, int number) {
		Long[] input = new Long[number];
		for (int i = 0; i < number; i++) {
			input[i] = scan.nextLong();
		}
		return input;
	}
}
