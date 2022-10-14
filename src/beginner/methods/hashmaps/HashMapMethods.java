package beginner.methods.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import myutil.CustomException;
import myutil.MyUtil;

public class HashMapMethods {

	public <K, V> Map<K, V> createHashmap() {
		HashMap<K, V> map = new HashMap<>();
		return map;
	}

	public <K, V> int hMSize(Map<K, V> input) throws CustomException {
		MyUtil.checkNull(input);
		return input.size();
	}

	public Map<String, String> putKeyValue(Map<String, String> input, String key, String value) throws CustomException {
		MyUtil.checkNull(input);
		input.put(key, value);
		return input;
	}
	
	public Map<Integer, Integer> putKeyValue(Map<Integer, Integer> input, int key, int value) throws CustomException {//swami
		MyUtil.checkNull(input);
		input.put(key, value);
		return input;
	}
	
	public Map<String, Integer> putKeyValue(Map<String, Integer> input, String key, int value) throws CustomException {
		MyUtil.checkNull(input);
		input.put(key, value);
		return input;
	}
	
	public Map<String, Object> putKeyValue(Map<String, Object> input, String key, Object value) throws CustomException {
		MyUtil.checkNull(input);
		input.put(key, value);
		return input;
	}

	public boolean keyExists(Map<String, String> input, String key) throws CustomException {
		MyUtil.checkNull(input);
		return input.containsKey(key);
	}

	public boolean valueExists(Map<String, String> input, String value) throws CustomException {
		MyUtil.checkNull(input);
		return input.containsValue(value);
	}

	public Map<String, String> replaceKey(Map<String, String> input, String key, String value) throws CustomException {
		MyUtil.checkNull(input);
		input.replace(key, value);
		return input;
	}

	public String getValue(Map<String, String> input, String key) throws CustomException {
		MyUtil.checkNull(input);
		return input.get(key);
	}

	public String absentKey(Map<String, String> input, String key, String value) throws CustomException {
		MyUtil.checkNull(input);
		input.putIfAbsent(key, value);//swami
		return getValue(input,key);
	}

	public String removeKey(Map<String, String> input, String key) throws CustomException {
		MyUtil.checkNull(input);
		return input.remove(key);
	}

	public boolean removeKeyValue(Map<String, String> input, String key, String value) throws CustomException {
		MyUtil.checkNull(input);
		return input.remove(key, value);
	}

	public Map<String, String> replaceValue(Map<String, String> input, String key, String oldValue, String newValue)
			throws CustomException {
		MyUtil.checkNull(input);
		input.replace(key, oldValue, newValue);
		return input;
	}

	public Map<String, String> copyMap(Map<String, String> input1, Map<String, String> input2) throws CustomException {
		MyUtil.checkNull(input1);
		MyUtil.checkNull(input2);
		input2.putAll(input1);
		return input2;
	}
	
	public Set<Entry<String, String>> iterateMap(Map<String, String> input) throws CustomException {
		MyUtil.checkNull(input);
//		input.forEach((K, V) -> System.out.println("Key : " + K + ", Value : " + V)); //swami use map entry
		return input.entrySet();
	}

	public Map<String, String> clearMap(Map<String, String> input) throws CustomException {
		MyUtil.checkNull(input);
		input.clear();
		return input;
	}
}
