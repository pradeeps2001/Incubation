package runner.regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import beginner.methods.regex.RegexMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class RegexRunner {

	private static final Logger logger = Logger.getLogger(RegexRunner.class.getName());

	public static void main(String[] args) {

		RegexMethods helperObj = new RegexMethods();
		Scanner scan = new Scanner(System.in);
		String decision;
		do {
			System.out.print("Enter the experiment : ");
			int choice = MyUtil.checkInt(scan);
			try {
				switch (choice) {
				case 1: {
					logger.info("Enter 10 digit mobile number : ");
					String input = scan.next();
					if (helperObj.checkMobileNo(input)) {
						logger.info("The given pattern matches the mobile number.");
					} else {
						logger.info("The given pattern does not match.");
					}
					break;
				}
				case 2: {
					logger.info("Enter an alphanumeric string : ");
					String input = scan.next();
					if (helperObj.checkAlphaNumeric(input)) {
						logger.info("The given pattern matches alphanumeric.");
					} else {
						logger.info("The given pattern does not match.");
					}
					break;
				}
				case 3: {
					logger.info("Enter a pattern : ");
					String given = scan.next();
					logger.info("Enter a matching type : ");
					String matching = scan.next();
					if (helperObj.startsWith(given, matching)) {
						logger.info("The given pattern starts with " + matching + ".");
					} else if (helperObj.containString(given, matching)) {
						logger.info("The given pattern contains " + matching + ".");
					} else if (helperObj.endsWith(given, matching)) {
						logger.info("The given pattern ends with " + matching + ".");
					} else if (helperObj.exactMatch(given, matching)) {
						logger.info("The given pattern matches exactly " + matching + ".");
					} else {
						logger.info("The given pattern does not matches" + matching + ".");
					}
					break;
				}
				case 4: {
					List<String> list = helperObj.createList();
					logger.info("Enter no. of elements to add : ");
					int num = MyUtil.checkInt(scan);
					for (int i = 1; i <= num; i++) {
						logger.info("Enter string " + i);
						String element = scan.next();
						helperObj.addElements(list, element);
					}
					logger.info("Enter the matching string : ");
					String matching = scan.next();
					int len = list.size();
					for (int i = 0; i < len; i++) {
						String element = list.get(i);
						if (helperObj.hasDuplicates(element, matching)) {
							logger.info("Duplicate present at " + i);
						} else {
							logger.info("Index " + i + " does not contain  " + matching + ".");
						}
					}
					break;
				}
				case 5: {
					logger.info("Enter the EmailID with '@' and '.' ");
					String email = scan.next();
					if (helperObj.validateEmail(email)) {
						logger.info("The given email is valid.");
					} else {
						logger.info("The email is not valid.");
					}
					break;
				}
				case 6: {
					List<String> list = helperObj.createList();
					logger.info("Enter no. of elements to add : ");
					int num = MyUtil.checkInt(scan);
					for (int i = 1; i <= num; i++) {
						logger.info("Enter string " + i);
						String element = scan.next();
						helperObj.addElements(list, element);
					}
					logger.info("Enter initial size : ");
					int first = MyUtil.checkInt(scan);
					logger.info("Enter final size : ");
					int last = MyUtil.checkInt(scan);
					int len = list.size();
					for (int i = 0; i < len; i++) {
						String element = list.get(i);
						if (helperObj.stringWithSize(element, first, last)) {
							logger.info("String is within given limit.");
						} else {
							logger.info("String is out of limit.");
						}
					}
					break;
				}
				case 7: {
					List<String> list1 = helperObj.createList();
					logger.info("Enter no. of elements to add in given list : ");
					int num1 = MyUtil.checkInt(scan);
					for (int i = 1; i <= num1; i++) {
						logger.info("Enter string " + i);
						String element = scan.next();
						helperObj.addElements(list1, element);
					}
					List<String> list2 = helperObj.createList();
					logger.info("Enter no of elements to add in matching list : ");
					int num2 = MyUtil.checkInt(scan);
					for (int i = 1; i <= num2; i++) {
						logger.info("Enter string " + i);
						String element = scan.next();
						helperObj.addElements(list2, element);
					}

					Map<String, Integer> map = new HashMap<>();
					if (helperObj.checkLists(list1, list2)) {
						for (int i = 0; i < num2; i++) {
							String matching = list2.get(i);
							for (int j = 0; j < num1; j++) {
								String given = list1.get(j);
								if (helperObj.exactMatch(given, matching)) {
									helperObj.putKeyValue(map, matching, j);
								}
							}
						}
						logger.info(map.toString());
					} else {
						logger.info("Enter valid matching list size.");
					}
					break;
				}
				case 8: {
					logger.info("The html tags of : \n"
							+ "<p>The <code>President</code> of India is the first citizen of our country.</p>");
					String input = "<p>The <code>President</code> of India is the first citizen of our country.</p>";
					logger.info(helperObj.getHtmlTags(input));
					break;
				}
				default:
					System.out.println("No matching case.");
				}
			} catch (CustomException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to retry : yes/no");
			decision = scan.next();
		} while (decision.equalsIgnoreCase("yes"));
	}
}
