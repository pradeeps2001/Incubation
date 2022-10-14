package beginner.methods.pojo;

// experiment 5
public class OverloadConstructor {

	public String data;
	
	public OverloadConstructor() {
		
	}
	
	public OverloadConstructor(String input) {
		this.data = input;
	}
	
	@Override
	public String toString() {
		return data;
	}
}
