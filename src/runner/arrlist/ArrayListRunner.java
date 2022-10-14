package runner.arrlist;

import java.util.List;
import java.util.Scanner;

import beginner.methods.arrlist.ArrayListMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class ArrayListRunner {

	public void sanityCheckMethod() throws CustomException {
//		ArrayListMethods helperObj = new ArrayListMethods();
//		List<Object> list = null;
//		try {
//		System.out.println(helperObj.listSize(list));
//		helperObj.addElements(list, null);
//		helperObj.addObjects(null, 0);
//		helperObj.findIndex(null, null);
//		helperObj.printList(null);
//		helperObj.getElement(null, 0);
//		helperObj.getFirstDuplicate(null, null);
//		helperObj.getLastDuplicate(null, null);
//		helperObj.insertElement(null, null, 0);
//		helperObj.subList(null, 0, 0);
//		helperObj.copyList(null, null, null);
//		helperObj.removeElement(null, 0);
//		helperObj.removeExisitng(null, null);
//		helperObj.removeSubList(null, 0, 0);
//		helperObj.retainExisitng(null, null);
//		helperObj.clearList(null);
//		helperObj.containElement(null, null);
//		} catch (CustomException e) {
//			e.printStackTrace();
//		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws CustomException {

		ArrayListRunner testerObj = new ArrayListRunner();
		ArrayListMethods helperObj = new ArrayListMethods();
		String decision;
		Scanner scan = new Scanner(System.in);

		try {
			do {
				System.out.print("Enter the experiment : ");
				int choice = MyUtil.checkInt(scan);
				switch (choice) {
				case 1: {
					List<String> list = helperObj.createArrayList();
					int len = helperObj.listSize(list);
					System.out.println("The length of ArrayList " + list + " is : " + len);
					break;
				}
				case 2: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					int len = helperObj.listSize(list);
					System.out.println("The ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 3: {
					List<Integer> list = helperObj.createArrayList();
					System.out.print("Enter the no of Integers to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " Numbers : ");
					helperObj.addElements(list, MyUtil.getIntInput(scan, inputNum));
					int len = helperObj.listSize(list);
					System.out.println("The ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 4: {
					List<Object> list = helperObj.createArrayList();
					System.out.print("Enter the no of Objects to add : ");
					int inputNum = MyUtil.checkInt(scan);
					helperObj.addObjects(list, inputNum);
					int len = helperObj.listSize(list);
					System.out.println(list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 5: {
					List list = helperObj.createArrayList();
					System.out.print("Enter the no of Integers to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " Numbers : ");
					list = helperObj.addElements(list, MyUtil.getIntInput(scan, inputNum));
					System.out.println(list);
					System.out.print("Enter the no of Strings to add : ");
					int inputNum1 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum1 + " String : ");
					list = helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum1));
					System.out.print("Enter the no of Objects to add : ");
					int inputNum2 = MyUtil.checkInt(scan);
					list = helperObj.addObjects(list, inputNum2);
					int len = helperObj.listSize(list);
					System.out.println(list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 6: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					System.out.println(list);
					System.out.print("Enter the String to find Index : ");
					String find = scan.next();
					int index = helperObj.findIndex(list, find);
					int len = helperObj.listSize(list);
					System.out
							.println("The index of " + find + " is : " + index + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 7: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					System.out.print("The List element are : ");
					String[] name = helperObj.printList(list);
					for (Object i : name) {
						System.out.print(i + " ");
					}
					System.out.println();
					break;
				}
				case 8: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					System.out.print("Choose an index less than " + (list.size() - 1) + " : ");
					int index = MyUtil.checkInt(scan);
					String output = helperObj.getElement(list, index);
					int len = helperObj.listSize(list);
					System.out.println(
							"The String at index " + index + " is : " + output + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 9: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					System.out.print("Enter the duplicate to find : ");
					String duplicate = scan.next();
					int first = helperObj.getFirstDuplicate(list, duplicate);
					int last = helperObj.getLastDuplicate(list, duplicate);
					int len = helperObj.listSize(list);
					System.out.print("First duplicate is at : " + first + "\nLast duplicate is at : " + last
							+ "\nThe size of ArrayList is : " + len);
					break;
				}
				case 10: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					System.out.print("Enter an index less than " + (list.size() - 1) + " to replace : ");
					int index = MyUtil.checkInt(scan);
					System.out.print("Enter a String to replace : ");
					String replace = scan.next();
					list = helperObj.insertElement(list, replace, index);
					int len = helperObj.listSize(list);
					System.out.println("ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 11: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum));
					System.out.println("Enter index less than " + (list.size() - 1));
					System.out.print("Enter starting index : ");
					int index1 = MyUtil.checkInt(scan);
					System.out.print("Enter ending index : ");
					int index2 = MyUtil.checkInt(scan);
					list = helperObj.subList(list, index1, index2);
					int len = helperObj.listSize(list);
					System.out.println("ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 12: {
					List<String> list1 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in First ArrayList : ");
					int inputNum1 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum1 + " String : ");
					helperObj.addElements(list1, MyUtil.getStrInput(scan, inputNum1));
					List<String> list2 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in Second ArrayList : ");
					int inputNum2 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum2 + " String : ");
					helperObj.addElements(list2, MyUtil.getStrInput(scan, inputNum2));
					List<String> list3 = helperObj.createArrayList();
					list3 = helperObj.copyList(list1, list2, list3);
					int len = helperObj.listSize(list3);
					System.out.println("Copied ArrayList is " + list3 + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 13: {
					List<String> list1 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in First ArrayList : ");
					int inputNum1 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum1 + " String : ");
					helperObj.addElements(list1, MyUtil.getStrInput(scan, inputNum1));
					List<String> list2 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in Second ArrayList : ");
					int inputNum2 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum2 + " String : ");
					helperObj.addElements(list2, MyUtil.getStrInput(scan, inputNum2));
					List<String> list3 = helperObj.createArrayList();
					list3 = helperObj.copyList(list2, list1, list3);
					int len = helperObj.listSize(list3);
					System.out.println("Copied ArrayList is " + list3 + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 14: {
					List<Double> list = helperObj.createArrayList();
					System.out.print("Enter the no of decimals to add in ArrayList : ");
					int inputNum = scan.nextInt();
					System.out.print("Enter " + inputNum + " decimals : ");
					helperObj.addElements(list, MyUtil.getDoubleInput(scan, inputNum));
					System.out.println("ArrayList is : " + list);
					System.out.println("Enter index less than " + (list.size() - 1) + " to remove : ");
					int index = MyUtil.checkInt(scan);
					list = helperObj.removeElement(list, index);
					int len = helperObj.listSize(list);
					System.out.println("ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 15: {
					List<Double> list = helperObj.createArrayList();
					System.out.print("Enter the no of decimals to add in ArrayList : ");
					int inputNum = scan.nextInt();
					System.out.print("Enter " + inputNum + " decimals : ");
					helperObj.addElements(list, MyUtil.getDoubleInput(scan, inputNum));
					System.out.println("ArrayList is : " + list);
					System.out.println("Enter index less than " + (list.size() - 1) + " to remove : ");
					int index = MyUtil.checkInt(scan);
					list = helperObj.removeElement(list, index);
					int len = helperObj.listSize(list);
					System.out.println("ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 16: {
					List<Long> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add : ");
					int inputNum = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum + " String : ");
					helperObj.addElements(list, MyUtil.getLongInput(scan, inputNum));
					System.out.println(list);
					System.out.println("Enter index less than " + (list.size() - 1));
					System.out.print("Enter starting index : ");
					int index1 = MyUtil.checkInt(scan);
					System.out.print("Enter ending index : ");
					int index2 = MyUtil.checkInt(scan);
					list = helperObj.removeSubList(list, index1, index2);
					int len = helperObj.listSize(list);
					System.out.println("ArrayList is " + list + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 17: {
					List<String> list1 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in First ArrayList : ");
					int inputNum1 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum1 + " String : ");
					helperObj.addElements(list1, MyUtil.getStrInput(scan, inputNum1));
					List<String> list2 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in Second ArrayList : ");
					int inputNum2 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum2 + " String : ");
					helperObj.addElements(list2, MyUtil.getStrInput(scan, inputNum2));
					list1 = helperObj.removeExisitng(list1, list2);
					int len = helperObj.listSize(list1);
					System.out.println("ArrayList is " + list1 + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 18: {
					List<String> list1 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in First ArrayList : ");
					int inputNum1 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum1 + " String : ");
					helperObj.addElements(list1, MyUtil.getStrInput(scan, inputNum1));
					List<String> list2 = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in Second ArrayList : ");
					int inputNum2 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum2 + " String : ");
					helperObj.addElements(list2, MyUtil.getStrInput(scan, inputNum2));
					list1 = helperObj.retainExisitng(list1, list2);
					int len = helperObj.listSize(list1);
					System.out.println("ArrayList is " + list1 + "\nThe size of ArrayList is : " + len);
					break;
				}
				case 19: {
					List<Long> list = helperObj.createArrayList();
					System.out.print("Enter the no of decimals to add in ArrayList : ");
					int inputNum = scan.nextInt();
					System.out.print("Enter " + inputNum + " decimals : ");
					helperObj.addElements(list, MyUtil.getLongInput(scan, inputNum));
					System.out.println("ArrayList before removal is : " + list);
					list = helperObj.clearList(list);
					System.out.println("ArrayList after removal is : " + list);
					break;
				}
				case 20: {
					List<String> list = helperObj.createArrayList();
					System.out.print("Enter the no of Strings to add in First ArrayList : ");
					int inputNum1 = MyUtil.checkInt(scan);
					System.out.print("Enter " + inputNum1 + " String : ");
					helperObj.addElements(list, MyUtil.getStrInput(scan, inputNum1));
					System.out.println("Enter the element to search : ");
					String input = scan.next();
					System.out.println(helperObj.containElement(list, input));
					break;
				}
				case 100: {
					testerObj.sanityCheckMethod();
					break;
				}
				default:
					System.out.println("No matching case.");
				}
				System.out.println("Do you want to retry : yes/no");
				decision = scan.next();
			} while (decision.equalsIgnoreCase("yes"));
		} catch (CustomException e) {
			e.printStackTrace();
		}

	}

}
