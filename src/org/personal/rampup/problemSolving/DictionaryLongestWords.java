package org.personal.rampup.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/*
@FunctionalInterface
interface AnagramSolution {
    Set<Set<String>> group(List<String> words);
}*/
public class DictionaryLongestWords {
    public static void main(String[] args) {
//        String[] dictionary = {"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"};
        Dictionary dictionary = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});

//        List<String> dictionary = Arrays.asList("to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana");
        String inputStr1 = "toe";
        String inputStr2 = "osetdg";
        String inputStr3 = "oetdg";
        String inputStr4 = "nanabaook";

        List<String> resultString1 = searchLongestWords(dictionary, inputStr1);
        System.out.println(resultString1);
        List<String> resultString2 = searchLongestWords(dictionary, inputStr2);
        System.out.println(resultString2);
        List<String> resultString3 = searchLongestWords(dictionary, inputStr3);
        System.out.println(resultString3);
        List<String> resultString4 = searchLongestWords(dictionary, inputStr4);
        System.out.println(resultString4);


    }


    static List<String> searchLongestWords(Dictionary dictionary, String inputString) {

        List<String> dict = Arrays.asList(dictionary.getEntries());
        List<Character> providedStringCharList = new ArrayList<Character>();
        for (char c : inputString.toLowerCase().toCharArray()) {
            providedStringCharList.add(c);
        }
        int longest = 0;
        List<String> outPutString = new ArrayList<>();
        for (String s : dict) {
            int literalCount = 0;
            char[] tempCharArray = s.toCharArray();
            for (int k = 0; k < tempCharArray.length; k++) {
                if (providedStringCharList.contains(Character.toLowerCase(tempCharArray[k]))) {
                    literalCount++;
                }
                if (literalCount == tempCharArray.length && literalCount >= longest) {
                    if (outPutString.size() > 0 && outPutString.get(0).length() < literalCount) {
                        outPutString.remove(0);
                    }
                    longest = literalCount;
                    outPutString.add(s);
                }
            }
        }

        return outPutString;
    }
}


class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }

    public String[] getEntries() {
        return entries;
    }

    public void setEntries(String[] entries) {
        this.entries = entries;
    }
}


/*


import java.util.*;

class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }

    public String[] getEntries(){
        return entries;
    }
}

public class Solution {
    public static Set<String> longestWord(String letters, Dictionary dict) {
        List<String> dictList = Arrays.asList(dict.getEntries());
        List<Character> charListLetters = new ArrayList<>();
        for(char ch: letters.toCharArray()){
            charListLetters.add(ch);
        }

        Set<String> result = new HashSet<String>();
        int longest = 0;
        List<String> tempResult = new ArrayList<>();
        for(String curString: dictList){
            int literalCount = 0;
            char [] tempCharArr = curString.toCharArray();
            for(int i=0;i<tempCharArr.length;i++){
                if(charListLetters.contains(tempCharArr[i])){
                    literalCount++;
                }
                if(literalCount == tempCharArr.length && literalCount >= longest){
                    if(tempResult.size() > 0 && tempResult.get(0).length() < literalCount){
                        tempResult.remove(0);
                    }
                    longest = literalCount;
                    tempResult.add(curString);
                }
            }
        }
        for(String s:tempResult){
            result.add(s);
        }
        //System.out.println(result);
        return result;

    }



    public static boolean doTestsPass() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});

        boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));

        return result;
    }
*/
  /*
    public static void main(String[] args) {
        if(doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.err.println("There are test failures");
        }
    }
}
*/