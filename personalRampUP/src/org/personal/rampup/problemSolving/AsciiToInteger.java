package org.personal.rampup.problemSolving;

public class AsciiToInteger {

    public static void main(String[] args) {
convertToInteger("12345");
        //        System.out.println((int)'0');
//        System.out.println((int)'9');
    }

    public static int convertToInteger(String s){

        int resultInteger = 0;
        for (int i = 0; i < s.length(); ++i)
            resultInteger = resultInteger * 10 + s.charAt(i) - '0';
        return resultInteger;
    }
}
