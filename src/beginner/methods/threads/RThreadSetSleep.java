package beginner.methods.threads;

public class RThreadSetSleep implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("Going to sleep - " + Thread.currentThread().getName());
			Thread.currentThread();
			Thread.sleep(4000);
			System.out.println("After sleeping - " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
