package org.personal.rampup.multithreading;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyUsingListExample {

	public static void main(String[] args) {
		List<Integer> trigger = new ArrayList<>();
		Thread producer = new Thread(new ProducerList(trigger), "producer");
		Thread consumer = new Thread(new ConsumerList(trigger), "consumer1");
		Thread consumer2 = new Thread(new ConsumerList(trigger), "consumer2");
//		Thread consumer3 = new Thread(new ConsumerList(trigger), "consumer3");
//		Thread consumer4 = new Thread(new ConsumerList(trigger), "consumer4");
//		Thread consumer5 = new Thread(new ConsumerList(trigger), "consumer5");
//		Thread consumer6 = new Thread(new ConsumerList(trigger), "consumer6");
		producer.start();
		consumer.start();
		consumer2.start();
//		consumer3.start();
//		consumer4.start();
//		consumer5.start();
//		consumer6.start();

	}

}

class ProducerList implements Runnable {

	public ProducerList(List<Integer>  inputTrigger) {
		this.trigger = inputTrigger;
	}

	List<Integer> trigger;
	
	@Override
	public void run() {

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
			while (trigger.size() == 10) {
				System.out.println("Producer has no more capacity to produce now!!");
				System.out.println("Producer wait called!!");
				trigger.wait();
			}
			trigger.add(1);
			Thread.sleep(1000);
			System.out.println("Producer produced trigger value: " + trigger);
			trigger.notifyAll();
			System.out.println("Producer Notify called!!");
		}
	}

}

class ConsumerList implements Runnable {

	List<Integer> trigger;

	public ConsumerList(List<Integer> trig) {
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
			while (trigger.size() == 0) {
				System.out.println(Thread.currentThread().getName() +" has nothing to consume here!!");
				System.out.println(Thread.currentThread().getName() +" wait called!!");
				trigger.wait();
			}
			System.out.println(Thread.currentThread().getName() +" consumed trigger value: " + trigger);
			trigger.remove(0);
			Thread.sleep(1000);
			trigger.notifyAll();
			System.out.println(Thread.currentThread().getName() +" Notify called!!");
		}

	}

}