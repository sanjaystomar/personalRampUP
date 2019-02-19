package org.personal.rampup.hackerRank.problemSolving;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = {-2, -3, -4, -8, -2, -9, -5, -3};
        int n = arr.length;
        int maxSum = maxSubArraySum(arr, n);
        System.out.println("Maximum sum of contiguous subArray is : " + maxSum);
    }

    private static int maxSubArraySum(int[] arr, int size) {
        int maxSoFar = arr[0], currMax = arr[0];
        for(int i=0; i< size; i++){
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
