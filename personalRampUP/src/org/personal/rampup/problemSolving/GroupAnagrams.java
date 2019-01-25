package org.personal.rampup.problemSolving;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> anagramList = Arrays.asList("cat", "dog", "god", "cat", "dairy", "diary", "eager", "agree" );
//        groupAnagrams(anagramList);
        System.out.println(groupAnagrams(anagramList).values());
    }

    public static Map<String,Set<String>> groupAnagrams(List<String> inputList){
            Map<String,Set<String>> resultList = new HashMap<>();
            for(String s: inputList){
                char[] charSequence = s.toCharArray();
                Arrays.sort(charSequence);
                StringBuilder charSequString = new StringBuilder("");
                for(char c: charSequence){
                    charSequString.append(c);
                }
                if(resultList.containsKey(charSequString.toString())){
                    resultList.get(charSequString.toString()).add(s);
                } else {
                    Set<String> toPutInResultList = new HashSet<String>();
                    toPutInResultList.add(s);
                    resultList.put(charSequString.toString(), toPutInResultList);
                }
            }

            return resultList;
    }
}
