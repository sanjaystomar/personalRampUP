package org.personal.rampup.problemSolving;

public class AddTwoFractions {
    public static void main(String[] args) {
        System.out.println(runTest());
//        gcdCalcualtion(12, 20);
//        lcmCalculation(12, 20);
    }

    public static int gcdCalcualtion(int a, int b) {
        int gcd = 0;
        gcd = Math.min(Math.abs(a), Math.abs(b));
        while (gcd > 0) {
            if (a % gcd == 0 && b % gcd == 0) {
                break;
            }
            gcd--;
        }
        System.out.println(gcd);
        return gcd;
    }

  /*  public static int lcmCalculation(int a, int b) {
//        int lcm = Math.max(Math.abs(a), Math.abs(b));
        int lcm = Math.multiplyExact(a, b) / gcdCalcualtion(a, b);
        System.out.println(lcm);
        return lcm;
    }*/

    public static boolean runTest() {
        int[] fraction1 = {5, 12};
        int[] fraction2 = {9, 20};
        int[] resultFraction = new int[2];
        resultFraction = addFractions(fraction1, fraction2);
        System.out.println(resultFraction[0] + "," + resultFraction[1]);
        return false;
    }

    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int[] resultFraction = new int[2];
// leave this initially
        if (fraction1.length == 0 && fraction2.length == 0) {
            throw new IllegalArgumentException("fractions provided values are not correct!");
        }
// till here
        int numerator1 = fraction1[0];
        int denominator1 = fraction1[1];
        int numerator2 = fraction2[0];
        int denominator2 = fraction2[1];

        if (denominator1 == 0 && denominator2 == 0) {
            throw new IllegalArgumentException("Both denominators can't be zero");
        }

        if (numerator1 == 0 && numerator2 == 0) {
            resultFraction[0] = 0;
            resultFraction[1] = 1;
            return resultFraction;
        }

        int resNumerator = (numerator1 * denominator2 + numerator2 * denominator1);
        int resDenominator = (denominator1 * denominator2);
        int gcdDivisor = gcdCalcualtion(resNumerator, resDenominator);
        resultFraction[0] = resNumerator / gcdDivisor;
        resultFraction[1] = resDenominator / gcdDivisor;
        return resultFraction;
    }
}


