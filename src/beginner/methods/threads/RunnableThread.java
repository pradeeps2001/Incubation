package beginner.methods.threads;

public class RunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println("RunnableThread Name : "+Thread.currentThread().getName() +
				"\nRunnableThread Priority : "+Thread.currentThread().getPriority() +
				"\nRunnableThread ID : "+Thread.currentThread().getId());
	}
}
