package org.personal.rampup.memory;

public class OutOfMemoryTest {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            OutOfMemoryTest outOfMemoryTest = new OutOfMemoryTest();
            outOfMemoryTest.str = new String("test" + count);
        }
    }
}
