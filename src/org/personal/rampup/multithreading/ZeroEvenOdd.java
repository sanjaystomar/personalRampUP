package org.personal.rampup.multithreading;

/**
 * Now working!!
 */
public class ZeroEvenOdd {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ZeroEvenOddTask("zero"), "zero");
        Thread t2 = new Thread(new ZeroEvenOddTask("even"), "even");
        Thread t3 = new Thread(new ZeroEvenOddTask("odd"), "odd");
        t1.start();
        t2.start();
        t3.start();
    }
}

class ZeroEvenOddTask implements Runnable {
    volatile String threadNumber;
    volatile static  boolean zeroFlag = true;

    static Object obj = new Object();
    volatile static int count = 1;

    public ZeroEvenOddTask(String threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        while (count < 10) {

            if (threadNumber.equals("zero")) {
                synchronized (obj) {
                    while (zeroFlag != true && count <=10) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(0);
                    zeroFlag = false;
                    obj.notifyAll();
                }
            }

            if (threadNumber.equals("even")) {
                synchronized (obj) {
                    while ((zeroFlag != false ||(zeroFlag == false && count % 2 != 0)) && count <=10) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(count);
                    count++;
                    zeroFlag = true;
                    obj.notifyAll();
                }
            }

            if (threadNumber.equals("odd")) {
                synchronized (obj) {
                    while ((zeroFlag != false ||(zeroFlag == false && count % 2 == 0)) && count <=10) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(count);
                    count++;
                    zeroFlag = true;
                    obj.notifyAll();
                }
            }
        }
    }
}
