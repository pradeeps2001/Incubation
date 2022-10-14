package beginner.methods.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myutil.CustomException;
import myutil.MyUtil;

public class RegexMethods {

	public boolean checkMobileNo(String number) throws CustomException {
		MyUtil.checkNull(number);
		String regex = "^[789]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}

	public boolean checkAlphaNumeric(String input) throws CustomException {
		MyUtil.checkNull(input);
		String regex = "^[a-zA-Z0-9]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	public boolean startsWith(String given, String matching) throws CustomException {
		MyUtil.checkNull(given);
		MyUtil.checkNull(matching);
		String regex = "^" + matching;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(given);
		return matcher.find();
	}

	public boolean containString(String given, String matching) throws CustomException {
		MyUtil.checkNull(given);
		MyUtil.checkNull(matching);
		Pattern pattern = Pattern.compile(matching);
		Matcher matcher = pattern.matcher(given);
		return matcher.find();
	}

	public boolean endsWith(String given, String matching) throws CustomException {
		MyUtil.checkNull(given);
		MyUtil.checkNull(matching);
		String regex = matching + "$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(given);
		return matcher.find();
	}

	public boolean exactMatch(String given, String matching) throws CustomException {
		MyUtil.checkNull(given);
		MyUtil.checkNull(matching);
		String regex = "^" + matching + "$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(given);
		return matcher.matches();
	}

	public List<String> createList() {
		List<String> list = new ArrayList<>();
		return list;
	}

	public boolean addElements(List<String> inputList, String input) throws CustomException {
		MyUtil.checkNull(inputList);
		MyUtil.checkNull(input);
		return inputList.add(input);
	}

	public boolean hasDuplicates(String given, String matching) throws CustomException {
		MyUtil.checkNull(given);
		MyUtil.checkNull(matching);
		String regex = "^" + matching + "$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(given);
		return matcher.matches();
	}

	public boolean validateEmail(String email) throws CustomException {
		MyUtil.checkNull(email);
		String regex = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean stringWithSize(String input, int initialSize, int finalSize) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkInBound(initialSize, finalSize);
		String regex = "^" + "\\w" + "{" + initialSize + "," + finalSize + "}" + "$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	public boolean checkLists(List<String> list1, List<String> list2) throws CustomException {
		return list2.size() <= list1.size();
	}

	public Map<String, Integer> createMap() {
		Map<String, Integer> map = new HashMap<>();
		return map;
	}

	public Map<String, Integer> putKeyValue(Map<String, Integer> input, String key, int value) throws CustomException {
		MyUtil.checkNull(key);
		input.put(key, value);
		return input;
	}

	public String getHtmlTags(String htmlString) throws CustomException {
		MyUtil.checkNull(htmlString);
		String regex = "(</?[a-z]*>)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(htmlString);
		String output = "";
		String newLine = "\n";
		while (matcher.find()) {
			output = output.concat(matcher.group()).concat(newLine);
		}
		return output;
	}
}
