package runner.hashmaps;

import java.util.Map;
import java.util.Scanner;

import beginner.methods.hashmaps.HashMapMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class HashMapRunner {

	public static void main(String[] args) throws CustomException {
		
		HashMapMethods helperObj = new HashMapMethods();
		String decision;
		Scanner scan = new Scanner(System.in);

		try {
			do {
				System.out.print("Enter the experiment : ");
				int choice = MyUtil.checkInt(scan);
				switch (choice) {
				case 1: {
					Map<String, String> map = helperObj.createHashmap();
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 2: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 3: {
					Map<Integer, Integer> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						Integer key = MyUtil.checkInt(scan);
						System.out.print("Enter Value : ");
						Integer value = MyUtil.checkInt(scan);
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 4: {
					Map<String, Integer> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						Integer value = MyUtil.checkInt(scan);
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 5: {
					Map<String, Object> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : \n");
						Object value = new HashMapRunner();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 6: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.print("Null Key : ");
					String nullKey = null;
					System.out.print("\nEnter Value : ");
					String value = scan.next();
					helperObj.putKeyValue(map, nullKey, value);
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 7: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.print("Null Key : ");
					String nullKey = null;
					System.out.print("\nNull Value : ");
					String nullValue = null;
					helperObj.putKeyValue(map, nullKey, nullValue);
					int size = helperObj.hMSize(map);
					System.out.println("\nThe HashMap is " + map + ".\nIts size is : " + size);
					break;
				}
				case 8: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.println("The HashMap is " + map);
					System.out.print("Enter a key to search : ");
					String search = scan.next();
					boolean output = helperObj.keyExists(map, search);
					System.out.println(output);
					break;
				}
				case 9: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.println("The HashMap is " + map);
					System.out.print("Enter a value to search : ");
					String search = scan.next();
					boolean output = helperObj.valueExists(map, search);
					System.out.println(output);
					break;
				}
				case 10: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter string Key : ");
						String key = scan.next();
						System.out.print("Enter integer Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap before is " + map + ".\nIts size is : " + size);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter string replace Key : ");
						String key = scan.next();
						System.out.print("Enter integer replace value : ");
						String value = scan.next();
						helperObj.replaceKey(map, key, value);
					}
					int size1 = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size1);
					break;
				}
				case 11: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.print("Enter the key to find its value : ");
					String key = scan.next();
					String output = helperObj.getValue(map, key);
					System.out.print("The value of the " + key + " is : " + output + "\n");
					break;
				}
				case 12: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter Key : ");
						String key = scan.next();
						System.out.print("Enter Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.print("Enter the key to find its value : ");
					String key = scan.next();
					String output = helperObj.getValue(map, key);
					System.out.print("The value of the \"" + key + "\" is : " + output + "\n");
					break;
				}
				case 13: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size);
					System.out.print("Enter a non-existing key : ");
					String key = scan.next();
					String absentValue = "Zoho";
					helperObj.absentKey(map, key, absentValue);
					int size1 = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size1);
					break;
				}
				case 14: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size);
					System.out.print("Enter a key to remove : ");
					String key = scan.next();
					helperObj.removeKey(map, key);
					int size1 = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size1);
					break;
				}
				case 15: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size);
					System.out.print("Enter a key to remove : ");
					String key = scan.next();
					System.out.print("Enter its value to remove : ");
					String value = scan.next();
					helperObj.removeKeyValue(map, key, value);
					int size1 = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size1);
					break;
				}
				case 16: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter string Key : ");
						String key = scan.next();
						System.out.print("Enter integer Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap before is " + map + ".\nIts size is : " + size);
					System.out.print("Enter string replace Key : ");
					String key = scan.next();
					System.out.print("Enter integer replace value : ");
					String value = scan.next();
					helperObj.replaceKey(map, key, value);
					int size1 = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size1);
					break;
				}
				case 17: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs to add : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size);
					System.out.print("Enter an existing key  : ");
					String key = scan.next();
					System.out.print("Enter its old value : ");
					String Oldvalue = scan.next();
					System.out.print("Enter its new value : ");
					String newValue = scan.next();
					helperObj.replaceValue(map, key, Oldvalue, newValue);
					int size1 = helperObj.hMSize(map);
					System.out.println("The HashMap after is " + map + ".\nIts size is : " + size1);
					break;
				}
				case 18: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs in 1st MAP: ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap is " + map + ".\nIts size is : " + size);

					Map<String, String> map1 = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs in 2nd Map : ");
					int inputNum1 = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum1; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map1, key, value);
					}
					int size1 = helperObj.hMSize(map1);
					System.out.println("The HashMap before copying is " + map1 + ".\nIts size is : " + size1);
					helperObj.copyMap(map, map1);
					int size2 = helperObj.hMSize(map1);
					System.out.println("The HashMap after copying is " + map1 + ".\nIts size is : " + size2);
					break;
				}
				case 19: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					System.out.println(helperObj.iterateMap(map)); 
					break;
				}
				case 20: {
					Map<String, String> map = helperObj.createHashmap();
					System.out.print("Enter the no of Key-Value pairs : ");
					int inputNum = MyUtil.checkInt(scan);
					for (int i = 0; i < inputNum; i++) {
						System.out.print("Enter String Key : ");
						String key = scan.next();
						System.out.print("Enter String Value : ");
						String value = scan.next();
						helperObj.putKeyValue(map, key, value);
					}
					int size = helperObj.hMSize(map);
					System.out.println("The HashMap before change is " + map + ".\nIts size is : " + size);
					helperObj.clearMap(map);
					int size2 = helperObj.hMSize(map);
					System.out.println("The HashMap after change is " + map + ".\nIts size is : " + size2);
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
