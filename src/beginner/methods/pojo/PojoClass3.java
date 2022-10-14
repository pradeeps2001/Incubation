package beginner.methods.pojo;

// experiment 8
public class PojoClass3 {
	
	public String name;
	public int age;

	public PojoClass3 () {
		
	}
	
	public PojoClass3 (String inputStr, int inputInt) {
		this.setPersonName(inputStr);
		this.setAge(inputInt);
	}
	
	public String getPersonName() {
		return name;
	}
	
	public void setPersonName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
