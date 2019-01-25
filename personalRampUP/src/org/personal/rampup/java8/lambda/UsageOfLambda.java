package org.personal.rampup.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class UsageOfLambda {
    static List<String> nameList = Arrays.asList("ram", "shyam", "Kamal", "raman");
    public static void main(String[] args) {
        nameList
                .stream()
//                .map(e -> e.length())
                .map(String::length)
                .forEach(System.out::println);

    }
}
