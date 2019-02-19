package org.personal.rampup.fundamentals;

public class MemoryUsed {
    String instanceVariable = "sanjay";
    String instanceWithNew = "";//new String("ram");

    public static void main(String[] args) {
        MemoryUsed memoryUsed = new MemoryUsed();
        int i =0;
        while(i<100){
            i =i++;
            memoryUsed.instanceWithNew = new String ("ram");
        }
    }
}
