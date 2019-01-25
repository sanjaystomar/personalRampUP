package org.personal.rampup.problemSolving;

import java.util.Arrays;

public class SortedArrayMedian {

    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38,54};
        int ar2[] = {2, 13, 17, 30, 45,60};

       /* int ar1[] = {1, 2, 3, 6};
        int ar2[] = {4, 6, 8, 10};*/

        System.out.println(findMedianSortedArrays(ar1, ar2));
    }

    public static int calculateMedian(int[] arr1, int[] arr2) {
        if (arr1.length == 2 || arr2.length == 2) {
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
        }
        int lMedian = getMedian(arr1);
        int rMedian = getMedian(arr2);


        if (lMedian == rMedian) {
            return lMedian;
        } else if (lMedian < rMedian) {
            return calculateMedian(Arrays.copyOfRange(arr1, arr1.length % 2 == 0 ? arr1.length / 2-1 : arr1.length / 2 , arr1.length), Arrays.copyOf(arr2, arr2.length % 2 == 0 ? arr2.length / 2 : arr2.length / 2+1));
        } else {
            return calculateMedian(Arrays.copyOf(arr1, arr1.length % 2 == 0 ? arr1.length / 2 : arr1.length / 2+1), Arrays.copyOfRange(arr2, arr2.length % 2 == 0 ? arr2.length / 2-1 : arr2.length / 2 , arr2.length));
        }
    }

    public static int getMedian(int[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[(arr.length-1)/ 2] + arr[(arr.length-1) / 2+1 ])/2;
        } else {
            return arr[(arr.length-1) / 2 +1 ];
        }
    }

//
public static double findMedianSortedArrays(int[] A, int[] B) {
    int m = A.length, n = B.length;
    int l = (m + n + 1) / 2;
    int r = (m + n + 2) / 2;
    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
}

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
    }
//



}
