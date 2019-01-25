package org.personal.rampup.problemSolving;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Finds the first character that does not repeat anywhere in the input string
 * Given "apple", the answer is "a"
 * Given "racecars", the answer is "e"
 **/
public class FirstNonRepeating {

    public static char findFirst(String input) {
        char theFirst =' ';
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        for(Map.Entry<Character, Integer> in: charMap.entrySet()){
            if( in.getValue()==1) {
                theFirst = in.getKey();
                break;
            }
        }
//        charMap.entrySet().stream().anyMatch(e->e.getValue().equals(1)).;
        // code goes here
        return (theFirst);
    }

    public static void main(String args[]) {

        String[] inputs = {"apple", "racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd'};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }
}
