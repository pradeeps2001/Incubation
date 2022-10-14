package beginner.methods.enums;

public enum SingletonEnum {

	FINAL;
	
	int value;
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static SingletonEnum getField() {
		return FINAL;
	}

}