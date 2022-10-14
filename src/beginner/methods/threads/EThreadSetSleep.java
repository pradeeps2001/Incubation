package beginner.methods.threads;

public class EThreadSetSleep extends Thread{

	public EThreadSetSleep() {

	}

	public EThreadSetSleep(String name) {
		super(name); //calls Thread class constructor that sets name
	}

	@Override
	public void run() {
		try {
//			Thread.currentThread().setName(name);
			System.out.println("Going to sleep - " + Thread.currentThread().getName());
			Thread.currentThread();
			Thread.sleep(3000);
			System.out.println("After sleeping - " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
