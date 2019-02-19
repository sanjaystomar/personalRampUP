package org.personal.rampup.hackerRank.basics;

import java.util.*;

public class IsPallindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        StringBuilder sb = new StringBuilder("");
        for(int i=A.length()-1; i>=0; i--){
            sb.append(A.charAt(i));
        }
        String reverse = sb.toString();
        if(reverse.equals(A)) System.out.println("Yes");
        else System.out.println("No");

//        char[] a = {'a', 'b', 'c'};
//        char[] b = {'A', 'b', 'c'};
        String a = "abc", b = "Abc";
//        String.valueOf(cha);


        char [] aChar = a.toCharArray();
        char [] bChar = b.toCharArray();
        Arrays.sort(aChar);
        Arrays.sort(bChar);
        if(String.valueOf(aChar).equalsIgnoreCase(String.valueOf(bChar))) System.out.println(true);
        else System.out.println(false);
    }
}
