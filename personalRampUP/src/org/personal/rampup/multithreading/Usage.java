package org.personal.rampup.multithreading;

public class Usage {

	public static void main(String[] args) {
		Thread t1 = new Thread(new LockTesting());
		Thread t2 = new Thread(new LockTesting());
//		Thread t3 = new Thread(new LockTesting());
//		Thread t4 = new Thread(new LockTesting());

		t1.start();
		t2.start();
//		t3.start();
//		t4.start();

	}

}
