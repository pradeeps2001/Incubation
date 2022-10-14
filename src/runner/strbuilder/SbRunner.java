package runner.strbuilder;

import java.util.Scanner;

import beginner.methods.strbuilder.SbMethods;
import myutil.CustomException;
import myutil.MyUtil;

public class SbRunner {

	public static void main(String[] args) throws CustomException {

		StringBuilder builder = new StringBuilder();
		SbMethods helperObj = new SbMethods();
		String decision;
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Enter the experiment :");
			int choice = MyUtil.checkInt(scan);
			try {
				switch (choice) {
				case 1:{				
					System.out.println("Empty string length : "+helperObj.getBuilderLength(builder));
					System.out.println("Enter a string : ");
					System.out.println("Final String : "+helperObj.getStringLine(builder,' ' , MyUtil.getStrInput(scan,1))+"\nLength : "+helperObj.getBuilderLength(builder));
					break;
				}
				case 2:{
					builder = new StringBuilder("First");
					System.out.println("Length of string \""+builder+"\" is : "+helperObj.getBuilderLength(builder));
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					System.out.println("Enter character to seperate :");
					char inputChar = scan.next().charAt(0);
					System.out.println("Enter the "+inputNum+" Strings :");
					System.out.println("The final string is : " + helperObj.getStringLine(builder,inputChar,MyUtil.getStrInput(scan,inputNum)) +"\nIts length is : " + helperObj.getBuilderLength(builder));
					break;
				}
				case 3:{
					builder = new StringBuilder();
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					System.out.println("Enter the string : ");
					System.out.println("String is \""+helperObj.getStringLine(builder, ' ', MyUtil.getStrInput(scan,inputNum))+"\". The length is "+helperObj.getBuilderLength(builder));
					System.out.print("Possible insert locations : ");
					int[] insertLocArr = helperObj.spaceLocations(builder,inputNum);		//displaying possible inserting locations
					for(int i=0;i<inputNum-1;i++) {
						System.out.print(insertLocArr[i]+" ");
					}
					System.out.println();
					System.out.println("Enter insert location : ");
					int insertLoc = MyUtil.checkInt(scan);
					System.out.println("Enter the string to be inserted : ");
					String insertStr = scan.nextLine();
					System.out.println("The final string is : \""+helperObj.insertString(builder, " ", insertStr, insertLoc)+"\".\nIts length is : "+helperObj.getBuilderLength(builder));
					break;
				}
				case 4:{
					builder = new StringBuilder();
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					System.out.println("Enter the strings : ");
					System.out.println("String is \""+helperObj.getStringLine(builder, ' ', MyUtil.getStrInput(scan,inputNum))+"\". The length is "+helperObj.getBuilderLength(builder));
					System.out.print("String ending locations are : ");
					int[] insertLocArr = helperObj.spaceLocations(builder,inputNum);		//displaying space locations
					for(int i=0;i<inputNum;i++) {
						System.out.print(insertLocArr[i]+" ");
					}
					System.out.println();
					System.out.println("Enter delete location : ");
					int delete1 = scan.nextInt();
					int delete2 = scan.nextInt();
					System.out.println("Deleted string is : \""+helperObj.deleteString(builder, delete1, delete2)+"\" and its length is : "+helperObj.getBuilderLength(builder));
					break;
				}
				case 5:{
					builder = new StringBuilder();
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					scan.nextLine();
					System.out.println("Enter the strings : ");
					System.out.println("String is \""+helperObj.getStringLine(builder, ' ', MyUtil.getStrInput(scan,inputNum))+"\". The length is "+helperObj.getBuilderLength(builder));
					System.out.println("Enter character to seperate words : ");
					char inputChr = scan.next().charAt(0);
					System.out.println("New string is \""+helperObj.findAndReplace(builder, ' ', inputChr)+"\". The length is : "+helperObj.getBuilderLength(builder));
					break;
				}
				case 6:{
					builder = new StringBuilder();
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					scan.nextLine();
					System.out.println("Enter the strings : ");
					System.out.println("String is \""+helperObj.getStringLine(builder, ' ', MyUtil.getStrInput(scan,inputNum))+"\". The length is "+helperObj.getBuilderLength(builder));
					System.out.println("Reversed string is \""+helperObj.reverseString(builder)+"\". The length is "+helperObj.getBuilderLength(builder));
					break;
				}
				case 7:{
					System.out.println("Enter minimum 10 char :");
					String input = scan.nextLine();
					builder = new StringBuilder(input);
					System.out.println("String is \""+builder+"\". The length is "+helperObj.getBuilderLength(builder));				
					System.out.println("Enter index values between (0 to "+helperObj.getBuilderLength(builder)+") to delete.");
					System.out.print("Index 1 : ");
					int index1 = MyUtil.checkInt(scan);
					System.out.print("Index 2 : ");
					int index2 = MyUtil.checkInt(scan);
					System.out.println("String is deleted. The final string is \""+helperObj.deleteString(builder, index1, index2)+"\". The length is "+helperObj.getBuilderLength(builder));
					break;
				}
				case 8:{
					System.out.println("Enter minimum 10 char :");
					String input = scan.nextLine();
					builder = new StringBuilder(input);
					System.out.println("String is \""+builder+"\". The length is "+helperObj.getBuilderLength(builder));				
					System.out.println("Enter index values between (0 to "+helperObj.getBuilderLength(builder)+") to replace.");
					System.out.print("Index 1 : ");
					int index1 = MyUtil.checkInt(scan);
					System.out.print("Index 2 : ");
					int index2 = MyUtil.checkInt(scan);
					scan.nextLine();
					System.out.println("Enter a string of length "+(index2-index1)+" to replace.");
					String replace = scan.nextLine();
					System.out.println("The replaced string is \""+helperObj.replaceString(builder, replace, index1, index2)+"\". The length is "+helperObj.getBuilderLength(builder));
					break;
				}
				case 9:{
					builder = new StringBuilder();
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					scan.nextLine();
					System.out.println("Enter the strings : ");
					System.out.println("String is \""+helperObj.getStringLine(builder, ' ', MyUtil.getStrInput(scan,inputNum))+"\". The length is "+helperObj.getBuilderLength(builder));
					System.out.println("Enter character to seperate words : ");
					char inputChr = scan.next().charAt(0);
					System.out.println("New string is \""+helperObj.findAndReplace(builder, ' ', inputChr)+"\". The length is : "+helperObj.getBuilderLength(builder));
					System.out.println("The first position of "+inputChr+" is "+helperObj.getFirstPos(builder, inputChr));
					break;
				}
				case 10:{
					builder = new StringBuilder();
					System.out.println("Enter no. of strings to add :");
					int inputNum = MyUtil.checkInt(scan);
					scan.nextLine();
					System.out.println("Enter the strings : ");
					System.out.println("String is \""+helperObj.getStringLine(builder, ' ', MyUtil.getStrInput(scan,inputNum))+"\". The length is "+helperObj.getBuilderLength(builder));
					System.out.println("Enter character to seperate words : ");
					char inputChr = scan.next().charAt(0);
					System.out.println("New string is \""+helperObj.findAndReplace(builder, ' ', inputChr)+"\". The length is : "+helperObj.getBuilderLength(builder));
					System.out.println("The last position of "+inputChr+" is "+helperObj.getLastPos(builder, inputChr));
					break;
				}
				default:
					System.out.println("No matching case.");
				}
			}catch(CustomException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to retry : yes/no");
			decision = scan.next();
		} while (decision.equalsIgnoreCase("yes"));

	}
}
