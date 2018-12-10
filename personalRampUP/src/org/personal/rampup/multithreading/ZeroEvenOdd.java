package org.personal.rampup.multithreading;

/**
 * Currently not working!!
 */
public class ZeroEvenOdd {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ZeroEvenOddTask(0));
        Thread t2 = new Thread(new ZeroEvenOddTask(1));
        Thread t3 = new Thread(new ZeroEvenOddTask(2));
        t1.start();
        t2.start();
        t3.start();
    }
}

class ZeroEvenOddTask implements Runnable {
    volatile int threadNumber;
    volatile boolean zeroFlag = false;

    static Object obj = new Object();
    volatile static int count = 0;

    public ZeroEvenOddTask(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            if (zeroFlag != true && threadNumber == 0) {
                synchronized (obj) {
                    try {
                        System.out.println(0);
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    zeroFlag = true;
                    count++;
                    notifyAll();
                }
            }

            if (zeroFlag == true && count % 2 != 0 && threadNumber == 1) {
                synchronized (obj) {
                    try {
                        System.out.println(count);
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    zeroFlag = false;
                    notifyAll();
                }
            }

            if (zeroFlag == true && count % 2 == 0 && threadNumber == 2) {
                synchronized (obj) {
                    try {
                        System.out.println(count);
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    zeroFlag = false;
                    notifyAll();
                }
            }
        }
    }
}
