package org.personal.rampup.generics;

import java.util.Arrays;

public class TestArrayGeneric {
    public static void main(String[] args) {
        Integer [] integersArray = {10,11,12,13,54,76,12};
        Number [] numbersArray = new Number[7];
        Float [] floatsArray = {10.2F, 20.2F, 13.9F};
//        It works just fine!!
        numbersArray = integersArray;
//        numbersArray = floatsArray;
//  Gives ArrayStoreException
//        numbersArray[0]= 1.2f;

        Arrays
                .stream(numbersArray)
                .forEach(e -> System.out.print(e));
    }
}
