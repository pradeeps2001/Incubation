package beginner.methods.arrlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import myutil.CustomException;
import myutil.MyUtil;
import runner.arrlist.ArrayListRunner;

public class ArrayListMethods {

	public <T> List<T> createArrayList() {
		List<T> list = new ArrayList<>();
		return list;
	}

	public <T> int listSize(List<T> input) throws CustomException {
		MyUtil.checkNull(input);
		return input.size();
	}

	public List<String> addElements(List<String> input, String... element) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(element);
		for (String string : element) {
			input.add(string);
		}
		return input;
	}

	public List<Integer> addElements(List<Integer> input, int... element) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(element);
		for (Integer integer : element) {
			input.add(integer);
		}
		return input;
	}
	
	public List<Double> addElements(List<Double> input, Double... element) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(element);
		for (Double dbl : element) {
			input.add(dbl);
		}
		return input;
	}
	
	public List<Long> addElements(List<Long> input, Long... element) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(element);
		for (Long lng : element) {
			input.add(lng);
		}
		return input;
	}
	
	public List<Object> addObjects(List<Object> input, int count) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(count);
		for (int i = 0; i < count; i++) {
			ArrayListRunner obj = new ArrayListRunner();
			input.add(obj);
		}
		return input;
	}
	
	public List<Object> addMultipleObjects(List<Object> input,int[] ints, String[] strs, int count) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(count);
		for (int i = 0; i < count; i++) {
			ArrayListRunner obj = new ArrayListRunner();
			input.add(obj);
		}
		return input;
	}

	public int findIndex(List<String> input, String element) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(element);
		int index = 0;
		for (String i : input) {
			if (i.equals(element)) {
				index = i.indexOf(element);
			}
		}
		return index;
	}

	public String[] printList(List<String> input) throws CustomException {
		MyUtil.checkNull(input);
		Iterator<String> iterator = input.iterator();
		String output[] = new String[input.size()];
		for (int i = 0; i < listSize(input); i++) {
			output[i] = iterator.next();
		}
		return output;
	}

	public String getElement(List<String> input, int index) throws CustomException {
		MyUtil.checkNull(input);
		String output = input.get(index);
		return output;
	}

	public int getFirstDuplicate(List<String> input, String duplicate) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(duplicate);
		return input.indexOf(duplicate);
	}

	public int getLastDuplicate(List<String> input, String duplicate) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkNull(duplicate);
		return input.lastIndexOf(duplicate);
	}

	public List<String> insertElement(List<String> inputList, String input, int index) throws CustomException {
		MyUtil.checkNull(input);
		MyUtil.checkInBound(inputList, 0, index);
		inputList.add(index, input);
		return inputList;
	}

	public List<String> subList(List<String> inputList, int index1, int index2) throws CustomException {
		MyUtil.checkNull(inputList);
		MyUtil.checkInBound(inputList, index1, index2);
		return inputList.subList(index1, index2);
	}
	
	public List<Long> subListLong(List<Long> inputList, int index1, int index2) throws CustomException {
		MyUtil.checkNull(inputList);
		MyUtil.checkInBound(inputList, index1, index2);
		return inputList.subList(index1, index2);
	}

	public List<String> copyList(List<String> copy1, List<String> copy2, List<String> original) throws CustomException {
		MyUtil.checkNull(copy1);
		MyUtil.checkNull(copy2);
		MyUtil.checkNull(original);
		original.addAll(copy1);
		original.addAll(copy2);
		return original;
	}

	public List<Double> removeElement(List<Double> inputList, int index) throws CustomException {
		MyUtil.checkNull(inputList);
		MyUtil.checkInBound(inputList, 0, index);
		inputList.remove(index);
		return inputList;
	}

	public List<Long> removeSubList(List<Long> inputList, int index1, int index2) throws CustomException {
		MyUtil.checkInBound(inputList, index1, index2);
		inputList.removeAll(subListLong(inputList, index1, index2));
		return inputList;
	}

	public List<String> removeExisitng(List<String> inputList1, List<String> inputList2) throws CustomException {
		MyUtil.checkNull(inputList1);
		MyUtil.checkNull(inputList2);
		inputList1.removeAll(inputList2);
		return inputList1;
	}

	public List<String> retainExisitng(List<String> inputList1, List<String> inputList2) throws CustomException {
		MyUtil.checkNull(inputList1);
		MyUtil.checkNull(inputList2);
		inputList1.retainAll(inputList2);
		return inputList1;
	}

	public List<Long> clearList(List<Long> inputList) throws CustomException {
		MyUtil.checkNull(inputList);
		inputList.clear();
		return inputList;
	}

	public boolean containElement(List<String> inputList, Object input) throws CustomException {
		MyUtil.checkNull(inputList);
		MyUtil.checkNull(input);
		return inputList.contains(input);
	}
}
