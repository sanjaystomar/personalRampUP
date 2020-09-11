package org.personal.rampup.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

public class ZeroOneArray {
    public static int[] zeroOneArr = {0, 2, 0, 0, 0, 3, 0, 4, 6, 0, 7, 0, 9, 0, 0, 2, 0, 0};
//    List<Integer> countZeros = new ArrayList<>();
//    List<Integer> countOnes = new ArrayList<>();

    public static void main(String[] args) {

        int k = 0, m = zeroOneArr.length - 1;

        while (k < m-1) {
            while (zeroOneArr[k] == 0) {
                k++;
            }
            while (zeroOneArr[m] != 0) {
                m--;
            }
            int temp = zeroOneArr[k];
            zeroOneArr[k] = zeroOneArr[m];
            zeroOneArr[m] = temp;
        }

        System.out.println(Arrays.toString(zeroOneArr));
//        for(int i=0; i< zeroOneArr.length-1; i++){
//            System.out.print(zeroOneArr[i]);
//            if(!(i==zeroOneArr.length-2))
//            System.out.print(", ");
//        }
//        Arrays.stream(zeroOneArr)
//                .map(Integer::toString)
//
//                        .collect(Collectors.joining(","));
////                forEach(System.out::print);
//
//        for(int )
    }
}
