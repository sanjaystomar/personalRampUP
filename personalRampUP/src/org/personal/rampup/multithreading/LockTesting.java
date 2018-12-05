package org.personal.rampup.multithreading;

public class LockTesting implements Runnable {

	@Override
	public void run() {
//		System.out.println("inside runnable in lockTesting : " + Thread.currentThread().getName());
		try {
			instanceMethod1();
			LockTesting.staticMethod1();
			instanceMethod2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void instanceMethod1() throws InterruptedException {
		Thread.sleep(100);
		System.out.println("synchronized instanceMethod1 : " + Thread.currentThread().getName());
		wait(10000);
		notify();
//		instanceMethod2(); 				// To check if both class level (Static) Lock and object level (instance) Lock
//		staticMethod1();					// To check if both class level (Static) Lock and object level (instance) Lock
	}
	
	public synchronized void instanceMethod2() throws InterruptedException {
		Thread.sleep(20000);
		notifyAll();	
		System.out.println("synchronized instanceMethod2 : " + Thread.currentThread().getName());
	}
	
	public static synchronized void staticMethod1() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("synchronized staticMethod1 : " + Thread.currentThread().getName());
	}

}


