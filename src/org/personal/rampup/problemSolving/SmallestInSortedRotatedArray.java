package org.personal.rampup.problemSolving;

public class SmallestInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 1, 2};
        int[] b = {2, 1};
        int[] c = {1};
        int[] d = {2, 3, 4, 5, 6};
        int[] e = {4, 1, 2, 3};
        int[] f = {13, 14, 15, 16, 11, 12, 18};
        int[] g = {};
        findSmallest(a);
        findSmallest(b);
        findSmallest(c);
        findSmallest(d);
        findSmallest(e);
        findSmallest(f);
//        findSmallest(g);  // test for null and empty array
    }

    public static int findSmallest(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            throw new IllegalArgumentException("invalid input array!!");
        } else {
            int calculateResult = calculate(inputArray, 0, inputArray.length - 1);
            System.out.println(calculateResult);
            return calculateResult;
        }
    }

    public static int calculate(int[] inputArray, int ltEnd, int rtEnd) {
        if (ltEnd == rtEnd)
            return inputArray[ltEnd];
        if (ltEnd > rtEnd)
            return inputArray[0];
        int mid = (rtEnd + ltEnd) / 2;
        if (mid < rtEnd && inputArray[mid] > inputArray[mid + 1])
            return inputArray[mid + 1];
        if (mid > ltEnd && inputArray[mid - 1] > inputArray[mid])
            return inputArray[mid];
        if (inputArray[rtEnd] > inputArray[mid])
            return calculate(inputArray, ltEnd, mid - 1);
        return calculate(inputArray, mid + 1, rtEnd);
    }
}
