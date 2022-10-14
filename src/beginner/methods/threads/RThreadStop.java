package beginner.methods.threads;

public class RThreadStop implements Runnable {

	private boolean value = true;

	public void setValue(boolean input) {
		this.value = input;
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
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " has Stopped...");
	}
}
