package org.personal.rampup.problemSolvingFresh;

import java.util.TreeSet;

public class LengthOfLongestFibonacciSequence {

//    create a new method
    public static int findLongestSequence(int inputArray[], int lengthOfArray) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for (int e : inputArray) {
            // Add each element into the set
            treeset.add(e);
        }
        int maxLen = 0, x, y;

        for (int i = 0; i < lengthOfArray; ++i) {
            for (int j = i + 1; j < lengthOfArray; ++j) {

                x = inputArray[j];
                y = inputArray[i] + inputArray[j];
                int length = 3;

                while (treeset.contains(y) && (y != treeset.last())) {

                    int z = x + y;
                    x = y;
                    y = z;
                    maxLen = Math.max(maxLen, length++);
                }
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }

    // Driver program
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8};
//        int A[] = {1, 3, 7, 11, 12, 14, 18};
        int n = A.length;
        System.out.print(findLongestSequence(A, n));
    }
}
