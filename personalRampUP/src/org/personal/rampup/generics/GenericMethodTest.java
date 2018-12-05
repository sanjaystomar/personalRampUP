package org.personal.rampup.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest {
    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.<String>firstGenericMethod("sanjay");

        System.out.println(genericMethods.<String, Integer>secondGenericMethod("fun", new Integer[]{1, 3, 5, 7, 4, 4}));
    }
}

class GenericMethods {
    public final <T> void firstGenericMethod(T arg) {
        System.out.println(arg);
        System.out.println("=========");
    }

    public <T, H> List<T> secondGenericMethod(T arg, H[] inValues) {
        List<T> returnList = new ArrayList<>();
        for (H input : inValues) {
//            if(!returnList.contains(input))
            returnList.add((T) input);
        }

        return returnList;
    }
}

/*class LowerBoundMethods {
    public <T super Number> void firstLowerBoundMethod(T inputValue) {

    }
}*/
