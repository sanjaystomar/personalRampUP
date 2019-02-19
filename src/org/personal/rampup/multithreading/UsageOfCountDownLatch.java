package org.personal.rampup.multithreading;

import java.util.concurrent.CountDownLatch;

/*
 *  from main run t1 t2 and once t1 t2 finished then run t3 t4
 * */
public class UsageOfCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch latch12 = new CountDownLatch(2);
        CountDownLatch latch34 = new CountDownLatch(2);
        Thread t1 = new Thread(new CountDownTask(null, latch12, 2000), "ThreadOne");
        Thread t2 = new Thread(new CountDownTask(null, latch12, 2000), "ThreadTwo");
        Thread t3 = new Thread(new CountDownTask(latch12, latch34, 500), "ThreadThree");
        Thread t4 = new Thread(new CountDownTask(latch12, latch34, 500), "ThreadFour");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            latch34.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class CountDownTask implements Runnable {
    private CountDownLatch waitiingLatch;
    private CountDownLatch myLatch;
    int sleep;
    public CountDownTask(CountDownLatch latch1, CountDownLatch latch2, int sleep) {
        this.waitiingLatch = latch1;
        this.myLatch = latch2;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            if (waitiingLatch != null)
                waitiingLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(sleep);
            System.out.println("Hi I'm there!!  : " + Thread.currentThread().getName());
        } catch (Exception e) {

        } finally {
            myLatch.countDown();
        }
    }
}

