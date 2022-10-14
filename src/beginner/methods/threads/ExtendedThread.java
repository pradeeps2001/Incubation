package beginner.methods.threads;

public class ExtendedThread extends Thread{

	public ExtendedThread() {

	}

	public ExtendedThread(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println("After start - \nExtendedThread Name : " + Thread.currentThread().getName() + "\nExtendedThread Priority : "
				+ Thread.currentThread().getPriority() + "\nExtendedThread ID : " + Thread.currentThread().getId());
	}
}
