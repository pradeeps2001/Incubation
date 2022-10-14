package beginner.methods.strbuilder;

import myutil.CustomException;
import myutil.MyUtil;

public class SbMethods {
	
	public int getBuilderLength(StringBuilder inputSb) throws CustomException {
		MyUtil.checkNull(inputSb);
		int len = inputSb.length();
		return len;
	}

	public StringBuilder appendString(StringBuilder inputSb, String delimiter, String inputStr) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputStr);
		return inputSb.append(delimiter).append(inputStr);
	}

	public StringBuilder getStringLine(StringBuilder inputSb, char delimiter, String... inputArr) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputArr);
		int len = inputArr.length;
		String stringChar = String.valueOf(delimiter);
		appendString(inputSb, "", inputArr[0]);
		for (int i = 1; i < len; i++) {
			appendString(inputSb, stringChar, inputArr[i]);
		}
		return inputSb;
	}

	public StringBuilder insertString(StringBuilder inputSb, String delimiter, String inputStr, int position) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputStr);
		MyUtil.checkInBound(inputSb, 0, position);
		inputStr = delimiter + inputStr;
		return inputSb.insert(position, inputStr);
	}

	public StringBuilder deleteString(StringBuilder inputSb, int index1, int index2) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkInBound(inputSb, index1, index2);
		return inputSb.delete(index1, index2);
	}

	public int getFirstPos(StringBuilder inputSb, char inputChar) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputChar);
		String chr = String.valueOf(inputChar);
		return inputSb.indexOf(chr);
	}

	public int getLastPos(StringBuilder inputSb, char inputChar) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputChar);
		String chr = String.valueOf(inputChar);
		return inputSb.lastIndexOf(chr);
	}

	public StringBuilder findAndReplace(StringBuilder inputSb, char delimiter, char inputChar) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputChar);
		String stringChar = String.valueOf(inputChar);
		for (int i = 0; i < getBuilderLength(inputSb); i++) {
			if (inputSb.charAt(i) == delimiter) {
				inputSb.replace(i, i + 1, stringChar);
			}
		}
		return inputSb;
	}

	public StringBuilder reverseString(StringBuilder inputSb) throws CustomException {
		MyUtil.checkNull(inputSb);
		return inputSb.reverse();
	}

	public StringBuilder replaceString(StringBuilder inputSb, String inputStr, int input1, int input2) throws CustomException {
		MyUtil.checkNull(inputSb);
		MyUtil.checkNull(inputStr);
		MyUtil.checkInBound(inputSb, input1, input2);
		return inputSb.replace(input1, input2, inputStr);
	}

	// prints the index of whitespace
	public int[] spaceLocations(StringBuilder inputSb, int StringNum) throws CustomException {
		MyUtil.checkNull(inputSb);
		int position = 0;
		int[] location = new int[StringNum];
		for (int i = 0; i < StringNum; i++) {
			if (i == 0) {
				position += inputSb.indexOf(" ");
			} 
			else if(i==(StringNum-1)){
				position = getBuilderLength(inputSb);
			}
			else {
				position = inputSb.indexOf(" ", position + 1);
			}
			location[i] = position;
		}
		System.out.println();
		return location;
	}
}
