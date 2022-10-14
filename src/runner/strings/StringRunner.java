package runner.strings;

import java.util.Arrays;
import java.util.Scanner;

import beginner.methods.strings.StringMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class StringRunner {

	public static void main(String[] args) throws CustomException {

		Scanner scan = new Scanner(System.in);

		StringMethods helperObj = new StringMethods();
		String decision;
		do {
			System.out.print("Enter the experiment : ");
			int choice = MyUtil.checkInt(scan);
			try {
				switch (choice) {

				case 1: {
					if (args.length > 0) {
						System.out.println("Length of the string is " + helperObj.getLength(args[0]));
					} else {
						System.out.println("Enter a valid string.\nRetry!!!");
					}
					break;
				}
				case 2: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					char[] charArr = helperObj.getCharArray(inputStr);
					System.out.print("Character Array is : ");
					for (char c : charArr) {
						System.out.print(c);
					}
					System.out.println("");
					break;
				}
				case 3: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("The penultimate character is " + helperObj.getPenultimate(inputStr));
					break;
				}
				case 4: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter a char :");
					char inputChar = scan.next().charAt(0);
					System.out.println("The no. of occurance of " + inputChar + " is "
							+ helperObj.getOccurance(inputStr, inputChar));
					break;
				}
				case 5: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter a char :");
					char inputChar = scan.next().charAt(0);
					System.out.println("Greatest position of the char " + inputChar + " in " + inputStr + " is : "
							+ helperObj.getGreatestPos(inputStr, inputChar));
					break;
				}
				case 6: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter number of characters to print from last :");
					int inputNum = MyUtil.checkInt(scan);
					System.out.println("The last " + inputNum + " characters of " + inputStr + " is :"
							+ helperObj.getSubstring(inputStr, inputStr.length() - inputNum, inputStr.length()));
					break;
				}
				case 7: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter number of characters to print from first :");
					int inputNum = MyUtil.checkInt(scan);
					System.out.println("The first " + inputNum + " characters of " + inputStr + " is :"
							+ helperObj.getSubstring(inputStr, 0, inputNum));
					break;
				}
				case 8: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter a characters to add in front :");
					String inputChr = scan.next();
					int stringLen = inputChr.length();
					System.out.println("New string is " + inputChr
							+ helperObj.getSubstring(inputStr, stringLen, inputStr.length()));
					break;
				}
				case 9: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter a starting characters to check :");
					String inputChr = scan.next();
					System.out.println(helperObj.checkSubString(inputStr, inputChr, 0, inputChr.length()));
					break;
				}
				case 10: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Enter a ending characters to check :");
					String inputChr = scan.next();
					System.out.println(helperObj.checkSubString(inputStr, inputChr,
							inputStr.length() - inputChr.length(), inputStr.length()));
					break;
				}
				case 11: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Upper case string is : " + helperObj.getCaps(inputStr));
					break;
				}
				case 12: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.println("Lower case string is : " + helperObj.getSmalls(inputStr));
					break;
				}
				case 13: {
					System.out.println("Enter a string :");
					String inputStr = scan.next();
					System.out.print("Reverse String is \""+helperObj.getReverse(inputStr)+"\".");
					System.out.println(); 
					break;
				}
				case 14: {
					System.out.println("Enter a line with multiple strings :");
					scan.nextLine();
					String inputStr = scan.nextLine();
					System.out.print("Multiple Strings are " + helperObj.getMultiString(inputStr));
					System.out.println();
					break;
				}
				case 15: {
					System.out.println("Enter a line with multiple strings :");
					scan.nextLine();
					String inputStr = scan.nextLine();
					System.out.print("Concatinated String " + helperObj.concatString(inputStr));
					System.out.println();
					break;
				}
				case 16: {
					System.out.println("Enter a line with multiple strings :");
					scan.nextLine();
					String inputStr = scan.nextLine();
					System.out.print("String Array is : " + Arrays.toString(helperObj.enclosedArray(inputStr)));
					System.out.println();
					break;
				}
				case 17: {
					System.out.println("Enter no. of words you want to enter :");
					int inputNum = MyUtil.checkInt(scan);
					System.out.println("Enter the character to add in middle :");
					char inputChar = scan.next().charAt(0);
					scan.nextLine();
					String[] output = new String[inputNum];
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter word " + (i + 1) + " : ");
						output[i] = scan.next();
					}
					System.out.print("Merged string is : " + helperObj.mergeString(output, inputChar));
					System.out.println();
					break;
				}
				case 18: {
					System.out.println("Enter String 1 :");
					scan.nextLine();
					String inputStr1 = scan.nextLine();
					System.out.println("Enter String 2 :");
					String inputStr2 = scan.nextLine();
					System.out.print("String is equal : " + helperObj.caseSensitive(inputStr1, inputStr2));
					System.out.println();
					break;
				}
				case 19: {
					System.out.println("Enter String 1 :");
					scan.nextLine();
					String inputStr1 = scan.nextLine();
					System.out.println("Enter String 2 :");
					String inputStr2 = scan.nextLine();
					System.out.print("String is equal : " + helperObj.caseInsensitive(inputStr1, inputStr2));
					System.out.println();
					break;
				}
				case 20: {
					System.out.println("Enter a sentence with space in front :");
					scan.nextLine();
					String inputStr = scan.nextLine();
					System.out.print("Trimmed String is : (" + helperObj.trimString(inputStr) + ")");
					System.out.println();
					break;
				}
				default:
					System.out.println("No matching choice");
				}
			} catch (CustomException e) {
				System.out.println(e);
			}
			System.out.println("Do you want to retry : yes/no");
			decision = scan.next();
		} while (decision.equalsIgnoreCase("yes"));
	}
}