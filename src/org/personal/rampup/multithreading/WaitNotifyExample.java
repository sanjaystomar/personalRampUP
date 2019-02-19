package org.personal.rampup.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyExample {

	public static void main(String[] args) {
		AtomicInteger trigger = new AtomicInteger(0);
		Thread producer = new Thread(new Producer(trigger), "producer");
		Thread consumer = new Thread(new Consumer(trigger), "consumer");
		
		producer.start();
		consumer.start();

	}

}

class Producer implements Runnable {

	public Producer(AtomicInteger inputTrigger) {
		this.trigger = inputTrigger;
	}

	private AtomicInteger trigger = new AtomicInteger();

	@Override
	public void run() {
		System.out.println("Currently running thread : " + Thread.currentThread().getName());

		while (true) {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produce() throws InterruptedException {
		synchronized (trigger) {
			while (trigger.get() == 10) {
				System.out.println("Producer has no more capacity to produce now!!");
				trigger.wait();
				System.out.println("Producer wait called!!");
			}
			trigger.incrementAndGet();
			Thread.sleep(1000);
			System.out.println("Producer produced trigger value: " + trigger);
			trigger.notify();
			System.out.println("Producer Notify called!!");
		}
	}

}

class Consumer implements Runnable {

	AtomicInteger trigger;

	public Consumer(AtomicInteger trig) {
		this.trigger = trig;
	}

	@Override
	public void run() {
		while (true) {

			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {

		synchronized (trigger) {
			while (trigger.get() == 0) {
				System.out.println("Consumer has nothing to consume here!!");
				trigger.wait();
				System.out.println("Consumer wait called!!");
			}
			System.out.println("Consumer consumed trigger value: " + trigger);
			trigger.decrementAndGet();
			Thread.sleep(1000);
			trigger.notify();
			System.out.println("Consumer Notify called!!");
		}

	}

}

final class ImmutableObject {

	public ImmutableObject(int counter) {
		super();
		this.counter = counter;
	}

	private final int counter;

	public int getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return "ImmutableObject [counter=" + counter + "]";
	}

}
