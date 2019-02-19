package org.personal.rampup.hackerRank.basics;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class IfElseExample {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Locale indiaLocale = new Locale("en", "IN");
//https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html
//https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        double x = 12450.00;
        System.out.println(us.format("x"));
        System.out.println(india.format("x"));
        System.out.println(china.format("x"));
        System.out.println(france.format("x"));

    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
            PrintStream printf = System.out.printf("%-s15%03d%n", s1, x);
        }

        System.out.println("================================");
    }

    public static void main2(String[] args) {
        //https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
            //Complete this line
        }
        System.out.println("================================");

    }

    /*  We use the integers , , and  to create the following series:

      You are given  queries in the form of , , and . For each query, print the series corresponding to the given , , and  values as a single line of  space-separated integers.*/
    public static void main3() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.multiplyExact((int) Math.pow(2, j), b);
                System.out.print(sum + a + " ");
            }
            System.out.println();
        }
        in.close();
    }

    public static void main4() {
        //https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                if (x >= -32768 && x <= 32767) System.out.println("* short");

                if (x >= Math.pow(-2, 31) && x <= Math.pow(2, 31) - 1) System.out.println("* int");
                if (x >= Math.pow(-2, 63) && x <= Math.pow(2, 63) - 1) System.out.println("* long");
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }

    public static void main5() {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while (scan.hasNext()) {
            System.out.println(++count + " " + scan.nextLine());
        }
    }


}
