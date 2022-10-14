package beginner.methods.inheritance;

public class ParrotMod extends BirdAbstract{

	@Override
	public void fly() {
		System.out.println("Parrots can fly.");
	}
	
	@Override
	public void speak() {
		System.out.println("Parrots speak.");
	}
}
