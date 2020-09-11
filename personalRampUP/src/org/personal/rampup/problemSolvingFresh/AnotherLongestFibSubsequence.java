package org.personal.rampup.problemSolvingFresh;

import java.util.Arrays;
import java.util.HashSet;

public class AnotherLongestFibSubsequence {

// Java program to find the length
// of longest subsequence of
// Fibonacci Numbers in an Array

    static final int N = 100005;

    // Function to create hash table
// to check Fibonacci numbers
    static void createHash(HashSet<Integer> hash, int maxElement) {
        int prev = 0, curr = 1;
        hash.add(prev);
        hash.add(curr);

        while (curr <= maxElement) {
            int temp = curr + prev;
            hash.add(temp);
            prev = curr;
            curr = temp;
        }
    }

    // Function to find the longest
// subsequence containing
// all Fibonacci numbers
    static int longestFibonacciSubsequence(
            int arr[], int n) {
        HashSet<Integer> hash = new HashSet<Integer>();
        createHash(
                hash, Arrays.stream(arr).max().getAsInt());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (hash.contains(arr[i])) {
                answer++;
            }
        }

        return answer;
    }

    // Driver code
    public static void main(String[] args) {
//        int arr[] = {3, 4, 11, 2, 9, 21};
        int arr[] = {1, 3, 7, 11, 12, 14, 18};

        int n = arr.length;

        // Function call
        System.out.print(longestFibonacciSubsequence(arr, n)
                + "\n");

    }
}
