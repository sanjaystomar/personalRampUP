package org.personal.rampup.problemSolving;

import java.sql.SQLOutput;

public class CalcualteExponent {
    public static void main(String[] args) {
        runTest();
    }

    public static void runTest() {
        int[] expArray = {3, 7, 9, 1, -3};
        double[] baseArray = {2.5, 4, 0, -9, 8};
        boolean[] passed = new boolean[expArray.length];
        int counter = 0;
        while (counter < expArray.length) {
            double result = calculateExponent(baseArray[counter], expArray[counter]);
            double expected = Math.pow(baseArray[counter], expArray[counter]);
           boolean curResult = Math.abs(expected- result) < .0001;
           passed[counter] = curResult;
            System.out.println(calculateExponent(baseArray[counter], expArray[counter]));
            counter++;
        }

        for(int i=0; i< passed.length; i++){
            System.out.println("Result is: " + passed[i]);
        }
    }

    public static double calculateExponent(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        int posExp = exponent < 0 ? exponent * -1 : exponent;
        double result = posExp % 2 == 0 ? calculateExponent(base * base, posExp) : base * calculateExponent(base * base, (posExp - 1) / 2);

        return exponent < 0 ? 1 / result : result;
    }
}
