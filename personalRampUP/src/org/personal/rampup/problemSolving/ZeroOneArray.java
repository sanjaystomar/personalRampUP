package org.personal.rampup.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroOneArray {
    public static int[] zeroOneArr = {0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0};
    List<Integer> countZeros = new ArrayList<>();
    List<Integer> countOnes = new ArrayList<>();


    public static void main(String[] args) {

        int k = 0, m = zeroOneArr.length - 1;

        while (k < m-1) {
            while (zeroOneArr[k] == 0) {
                k++;
            }
            while (zeroOneArr[m] == 1) {
                m--;
            }
            int temp = zeroOneArr[k];
            zeroOneArr[k] = zeroOneArr[m];
            zeroOneArr[m] = temp;
        }

        Arrays.stream(zeroOneArr).forEach(System.out::print);
    }
}
