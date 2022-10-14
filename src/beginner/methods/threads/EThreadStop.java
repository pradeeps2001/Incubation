package beginner.methods.threads;

public class EThreadStop extends Thread {

	private boolean value = true;//swami

	public EThreadStop(){
		
	}
	
	public EThreadStop(String name){
		super(name);
	}
	
	public void setValue(boolean input) {
		this.value = input;
	}
	
	@Override
	public void run() {
		
		while (value) {
			try {
				System.out.println("Going to sleep - " + getName());
				Thread.sleep(6000);
				System.out.println("After sleeping - " + getName());
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println( getName() + " has Stopped...");
	}
}
