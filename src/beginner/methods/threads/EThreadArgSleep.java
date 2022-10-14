package beginner.methods.threads;

public class EThreadArgSleep extends Thread {

	private int time;

	public EThreadArgSleep() {

	}

	public EThreadArgSleep(String name, int time) {
		super(name);
		this.time = time;
	}

	@Override
	public void run() {
		try {
//			Thread.currentThread().setName(name);//swami
			System.out.println("Going to sleep - " + Thread.currentThread().getName());
			//Thread.currentThread(); // swami
			Thread.sleep(time);
			System.out.println("After sleeping - " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
	}

}
