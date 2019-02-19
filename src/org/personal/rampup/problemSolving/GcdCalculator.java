package org.personal.rampup.problemSolving;

public class GcdCalculator {

    public static void main(String[] args) {
        int[] fraction = {218, 17};
        System.out.println(callGcdCalc(fraction));
    }

    private static int callGcdCalc(int[] fraction) {
        int x = fraction[0];
        int y = fraction[1];

        if (x > y) {
            if (x % y == 0) return y;
            return callGcdCalc(new int[]{y, x % y});
        } else if (y > x) {
            if (y % x == 0) return x;
            return callGcdCalc(new int[]{x, y % x});
        } else return x;
    }
}
