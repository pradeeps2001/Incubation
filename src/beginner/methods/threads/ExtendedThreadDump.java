package beginner.methods.threads;

public class ExtendedThreadDump extends Thread {

	private boolean value = true; // swami

	public ExtendedThreadDump(){
		
	}
	
	public ExtendedThreadDump(String name){
		super(name);
	}
	
	@Override
	public void run() {

		while (value) {
			try {
				System.out.println("Going to sleep - " + Thread.currentThread().getName());
				Thread.sleep(10000);
				System.out.println("After sleeping - " + Thread.currentThread().getName());
				System.out.println();
			} catch (InterruptedException e) {
				// swami
			}
		}
		
	}
}
