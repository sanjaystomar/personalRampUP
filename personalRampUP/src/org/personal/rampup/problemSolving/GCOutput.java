package org.personal.rampup.problemSolving;

public class GCOutput {
    static GCOutput gcOutput;
    static int count =0;

    public static void main(String[] args) throws InterruptedException{
        GCOutput gcOutput1 = new GCOutput();
        gcOutput1 = null;
        System.gc();
        Thread.sleep(1000);
        gcOutput=null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("finalize method called " + count + "times");
    }

    @Override
    protected void finalize(){
        count++;
        gcOutput= this;
    }
}
