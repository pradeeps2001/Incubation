package beginner.methods.enums;

public enum RainbowColors {

	Violet(1), Indigo(2), Blue(3), Green(4), Yellow(5), Orange(6), Red(7);

	public int value;

	RainbowColors(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
