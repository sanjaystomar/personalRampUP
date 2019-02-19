package org.personal.rampup.problemSolving;

public class SortedArrayMedianGFG {
    static int[] arr1 = {1, 12, 15, 26, 38, 54};
    static int[] arr2 = {2, 13, 17, 30, 45};

    public static void main(String[] args) {
        System.out.println(
                calculateMedian(arr1, arr2));
    }

    public static double calculateMedian(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        if (arr1.length == 0 || arr2Length == 0)
            throw new IllegalArgumentException("Both the arrays should have some elements!");
        int minIndex = 0, maxIndex = arr1Length > arr2Length ? arr2Length : arr1Length;
        int i = 0, j = 0;
        int median = 0;

        while (minIndex <= maxIndex) {
            i = (minIndex + maxIndex) / 2;
            j = (arr1Length + arr2Length + 1) / 2 - i;
            if (i < arr1Length && j > 0 && arr2[j - 1] > arr1[i]) minIndex = i + 1;
            else if (i > 0 && j < arr2Length && arr2[j] < arr1[i - 1]) maxIndex = i - 1;
            else {
                if (i == 0)
                    median = arr2[j - 1];
                else if (j == 0)
                    median = arr1[i - 1];
                else
                    median = Math.max(arr1[i - 1], arr2[j - 1]);
                break;
            }

        }

        if ((arr1Length + arr2Length) % 2 == 1) return (double) median;
        if (i == arr2Length) return (median + arr2[j]) / 2.0;
        if (j == arr1Length) return (median + arr1[i]) / 2.0;

        return (median + Math.min(arr1[i], arr2[j])) / 2.0;
    }
}
