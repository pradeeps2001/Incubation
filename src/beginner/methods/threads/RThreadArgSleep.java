package beginner.methods.threads;

public class RThreadArgSleep implements Runnable {

	int sleep;
	
	public RThreadArgSleep() {
		
	}

	public RThreadArgSleep(int time) {
		this.sleep = time;
	}

	@Override
	public void run() {
		try { 
			System.out.println("Going to sleep - "+Thread.currentThread().getName());
			Thread.sleep(sleep);
			System.out.println("After sleeping - "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();		
		}
	}
}
