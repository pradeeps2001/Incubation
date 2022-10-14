package beginner.methods.strings;

import myutil.CustomException;
import myutil.MyUtil;

public class StringMethods {
	
	public int getLength(String inputString) throws CustomException {
		// experiment 1
		MyUtil.checkNull(inputString);
		return inputString.length();
	}

	public char[] getCharArray(String inputString) throws CustomException {
		// experiment 2
		MyUtil.checkNull(inputString);
		char[] chArray = inputString.toCharArray();
		return chArray;
	}

	public char getPenultimate(String inputString) throws CustomException {
		// experiment 3
		char outputChar = inputString.charAt(getLength(inputString) - 2);
		return outputChar;
	}

	public int getOccurance(String inputString, char inputChr) throws CustomException {
		// experiment 4
		int count = 0;
		int n = getLength(inputString);
		for (int i = 0; i < n; i++) {
			if (inputString.charAt(i) == inputChr) {
				count++;
			}
		}
		return count;
	}

	public int getGreatestPos(String inputString, char inputChr) throws CustomException {
		// experiment 5
		MyUtil.checkNull(inputString);
		return inputString.lastIndexOf(inputChr) + 1;
	}

	public String getSubstring(String inputString, int startIndex, int endIndex) throws CustomException {
		// experiment 6,7,8
		MyUtil.checkNull(inputString);
		MyUtil.checkInBound(startIndex, endIndex);
		String str = inputString.substring(startIndex, endIndex);
		return str;
	}

	public boolean checkSubString(String inputString, String compareString, int start, int end) throws CustomException {
		// experiment 9 and 10
		MyUtil.checkInBound(getLength(inputString), getLength(compareString));
		return compareString.equals(getSubstring(inputString, start, end));
	}

	public String getCaps(String inputString) throws CustomException {
		// experiment 11
		MyUtil.checkNull(inputString);
		return inputString.toUpperCase();
	}

	public String getSmalls(String inputString) throws CustomException {
		// experiment 12
		MyUtil.checkNull(inputString);
		return inputString.toLowerCase();
	}

	public String getReverse(String inputString) throws CustomException {
		// experiment 13
		String reverse = "";
		char ch ;
		for (int i = getLength(inputString) - 1; i >= 0; i--) {
			ch = inputString.charAt(i);
			reverse += ch;
		}
		return reverse;
	}

	public String getMultiString(String inputString) throws CustomException {
		// experiment 14
		MyUtil.checkNull(inputString);
		return inputString;
	}

	public String concatString(String inputString) throws CustomException {
		// experiment 15
		MyUtil.checkNull(inputString);
		return inputString.replace(" ", "");
	}

	public String[] enclosedArray(String inputString) throws CustomException {
		// experiment 16
		MyUtil.checkNull(inputString);
		return inputString.trim().split(" ");
	}

	public String mergeString(String[] words, char inputChr) throws CustomException {
		// experiment 17
		String chr = String.valueOf(inputChr);
		return String.join(chr, words);
	}

	public boolean caseSensitive(String inputString1, String inputString2) throws CustomException {
		// experiment 18
		MyUtil.checkNull(inputString1);
		MyUtil.checkNull(inputString2);
		return inputString1.equals(inputString2);
	}

	public boolean caseInsensitive(String inputString1, String inputString2) throws CustomException {
		// experiment 19
		MyUtil.checkNull(inputString1);
		MyUtil.checkNull(inputString2);
		return inputString1.equalsIgnoreCase(inputString2);
	}

	public String trimString(String inputString) throws CustomException {
		// experiment 20
		MyUtil.checkNull(inputString);
		return inputString.trim();
	}
}