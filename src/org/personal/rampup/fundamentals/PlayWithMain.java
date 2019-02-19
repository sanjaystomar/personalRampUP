package org.personal.rampup.fundamentals;

public class PlayWithMain {

    //OVERLOADING: only called overloading if and only if the parameter list  | sequence changes

    public static void main(String[] args) {

    }

    protected static void main(String[] args, int i) {

    }

    public static int main(int i, String[] args) {
        return 0;
    }

}

abstract class AbstractClass {
    public AbstractClass() {
    }

    public abstract void findSum(int i, int j);




}
