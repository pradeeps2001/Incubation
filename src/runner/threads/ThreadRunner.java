package runner.threads;

import java.util.Scanner;

import beginner.methods.threads.*;
import myutil.MyUtil;

public class ThreadRunner extends Thread {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String decision;
		do {
			System.out.print("Enter the experiment : ");
			int choice = MyUtil.checkInt(scan);
			switch (choice) {
			case 1: {
				ExtendedThread thread = new ExtendedThread();
				System.out.println("BEFORE CALLING start()");
				System.out.println("Name : " + Thread.currentThread().getName());
				System.out.println("Priority : " + Thread.currentThread().getPriority());
				System.out.println("ID : " + Thread.currentThread().getId());
				System.out.println("AFTER CALLING start()");
				thread.start();
				thread.setName("First Thread");
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				RunnableThread work = new RunnableThread();
				Thread thread = new Thread(work);
				System.out.println("BEFORE CALLING start() : ");
				System.out.println("Name : " + Thread.currentThread().getName());
				System.out.println("Priority : " + Thread.currentThread().getPriority());
				System.out.println("ID : " + Thread.currentThread().getId());
				thread.start();
				thread.setName("Runnable Thread");
				System.out.println("AFTER CALLING start() : ");
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				ExtendedThread thread1 = new ExtendedThread();
				RunnableThread work = new RunnableThread();
				Thread thread2 = new Thread(work);
				thread1.setName("ExtendedThread");
				thread2.setName("Runnablethread");
				System.out.println("BEFORE CALLING start() : ");
				System.out.println("Name : " + Thread.currentThread().getName());
				System.out.println("Priority : " + Thread.currentThread().getPriority());
				System.out.println("ID : " + Thread.currentThread().getId());
				thread1.start();
				thread2.start();
				System.out.println("AFTER CALLING start() : ");
				try {
					thread1.join();
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			case 4: {

				System.out.print("Enter no. of ExtendedThreads to create : ");
				int ETnum = MyUtil.checkInt(scan);
				for (int i = 0; i < ETnum; i++) {
					System.out.print("Enter a name : ");
					String name = scan.next();
					EThreadSetSleep Ethread = new EThreadSetSleep(name);
					Ethread.start();
					try {
						Ethread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Enter no. of RunnableThreads to create : ");
				int RTnum = MyUtil.checkInt(scan);
				for (int i = 0; i < RTnum; i++) {
					System.out.print("Enter a name : ");
					String name = scan.next();
					RThreadSetSleep work = new RThreadSetSleep();
					Thread Rthread = new Thread(work, name);
					Rthread.start();
					try {
						Rthread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			}
			case 5: {
				System.out.print("Enter no. of ExtendedThreads to create : ");
				int ETnum = MyUtil.checkInt(scan);
				for (int i = 0; i < ETnum; i++) {
					System.out.print("Enter a name : ");
					String name = scan.next();
					System.out.print("Enter the sleep time for ExtendedThread " + name + " : ");
					int ETsleep = MyUtil.checkInt(scan);
					EThreadArgSleep Ethread = new EThreadArgSleep(name, ETsleep);
					Ethread.start();
					try {
						Ethread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Enter no. of RunnableThreads to create : ");
				int RTnum = MyUtil.checkInt(scan);
				for (int i = 0; i < RTnum; i++) {
					System.out.print("Enter a name : ");
					String name = scan.next();
					System.out.print("Enter the sleep time for RunnableThread " + name + " : ");
					int RTsleep = MyUtil.checkInt(scan);
					RThreadArgSleep work = new RThreadArgSleep(RTsleep);
					Thread Rthread = new Thread(work, name);
					Rthread.start();
					try {
						Rthread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			}
			case 6: {
				System.out.print("Enter no. of ExtendedThreads and RunnableThreads to create : ");
				int num = MyUtil.checkInt(scan);
				
				ExtendedThreadDump[] ExArr = new ExtendedThreadDump[num];
				RunnableThreadDump[] RnArr = new RunnableThreadDump[num];
				
				for (int i = 1; i <= num; i++) {
					ExtendedThreadDump Ethread = new ExtendedThreadDump("ExtendedThread " + i);
					ExArr[i-1] = Ethread;
					RunnableThreadDump work = new RunnableThreadDump();
					RnArr[i-1] = work;
					Thread Rthread = new Thread(work, "RunnableThread " + i);
					Ethread.start();
					Rthread.start();
				}
				break;
			}
			case 7: {
				System.out.print("Enter no. of ExtendedThreads and RunnableThreads to create : ");
				int num = MyUtil.checkInt(scan);
				
				EThreadStop[] ExArr = new EThreadStop[num];
				RThreadStop[] RnArr = new RThreadStop[num];

				for (int i = 1; i <= num; i++) {
					EThreadStop Ethread = new EThreadStop("ExtendedThread " + i);
					ExArr[i-1] = Ethread;
					RThreadStop work = new RThreadStop();
					RnArr[i-1] = work;
					Thread Rthread = new Thread(work, "RunnableThread " + i);
					Ethread.start();
					Rthread.start();
					try {
						Ethread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				for (int i = 0; i < num; i++) {
					try {
						Thread.sleep(20000);
						ExArr[i].setValue(false);
						RnArr[i].setValue(false);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				break;
			}
			default:
				System.out.println("No matching case.");
			}
			System.out.println("Do you want to retry : yes/no");
			decision = scan.next();
		} while (decision.equalsIgnoreCase("yes"));
	}

}
