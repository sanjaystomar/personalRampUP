package org.personal.rampup.multithreading;

public class PrintSentence {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TaskLogic("Hello", 0));
        Thread t2 = new Thread(new TaskLogic("Sanjay", 1));
        Thread t3 = new Thread(new TaskLogic("Singh TOMAR", 2));
        t1.start();
        t2.start();
        t3.start();
    }
}


class TaskLogic implements Runnable {

    private String stringValue;

    private int threadNumber;

    private static Object obj = new Object();

    private static int count = 0;

    public TaskLogic(String stringValue, int threadNumber) {
        this.stringValue = stringValue;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            synchronized (obj) {
                while (count % 3 != threadNumber) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(stringValue + " ");
                obj.notifyAll();
            }
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }
}
