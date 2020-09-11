package org.personal.rampup.random;

import java.util.ArrayList;
import java.util.List;

public class JustTestStream {
    static List<Integer> i = new ArrayList<>();

    public static void main(String[] args) {
        i.add(4);
        i.add(5);
        int sum = i.stream().reduce(0,(total,e) -> total+e);
    }
}
