package org.personal.rampup.hackerRank.basics;

import java.util.Scanner;

public class StringComparison {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        java.util.List<String> strList = new java.util.ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2) {
                String tempString = s.substring(i, i + 3);
                strList.add(tempString);
            }
        }
        strList.sort(String::compareTo);
        smallest = strList.get(0);
        largest = strList.get(strList.size()-1);


        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

