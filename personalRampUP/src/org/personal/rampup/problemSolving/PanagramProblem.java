package org.personal.rampup.problemSolving;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PanagramProblem {

    static String allAlphabets = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
//        String input = "The slow purple oryx meanders past the quiescent canine";
        String input = "The slow purple oryx meanders pas he quiescen canine";
        String input1 = " A quick brown fox jumps right over lazy dog";
        System.out.println(findMissingLetters(input.toLowerCase()));
        System.out.println(findMissingLetters(input1.toLowerCase()));
    }

    public static String findMissingLetters(String inputString) {
        Set<Character> refSet = new HashSet<>();
        for (Character ch : allAlphabets.toCharArray()) {
            refSet.add(ch);
        }
        for (Character ch : inputString.toCharArray()) {
            refSet.remove(ch);
        }
        Optional<String> missingElements = refSet
                .stream()
                .map(e -> e.toString())
                .reduce((e, output) -> e + output);
        if (missingElements.isPresent())
            return missingElements.get();

        return "-1";
    }
}
