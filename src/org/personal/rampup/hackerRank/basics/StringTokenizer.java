package org.personal.rampup.hackerRank.basics;

import java.io.*;
import java.util.*;

public class StringTokenizer {
//   [A-Za-z !,?._'@]+,
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();


        String s1 = "He is a very very good boy, isn't he?";
        String s = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
        String s2 = "";
        if(s2.length()==0) {
            System.out.println(0);
        } else if(s2.length() > 400000){

        } else {
            String regex1 = "[ ,?.']"; //"[ \\s?,'\\n]"    [ !,?.\\\\_'@]+
            String regex2 = "[ \\s?,!.@_'\\h+\\t\\n]+";
            String[] tokenArray = s2.trim().split(regex2);

            System.out.println(tokenArray.length);
            for (String st : tokenArray) {

                if (!st.isEmpty()) {

                    System.out.println(st);

                }
            }
        }
//        scan.close();
    }
}

