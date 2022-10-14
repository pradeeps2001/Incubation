package beginner.methods.pojo;

// experiment 6
public class PojoClass1 {

	public String name;
	public int age;
	
	public PojoClass1 (String inputStr, int inputInt) {
		this.setName(inputStr);
		this.setAge(inputInt);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int value) {
		this.age = value;
	}
	
	@Override
	public String toString() {
		return "Name : " + this.getName()+ "\nAge : " + this.getAge();
	}
}
