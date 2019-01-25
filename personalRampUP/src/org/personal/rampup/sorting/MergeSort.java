package org.personal.rampup.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

//        for (int i = 0; i < intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void mergeFun(int[] input, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] tempArr = new int[end - start];
        int tempIndex = 0;

        while (i < mid && j < end) {
            tempArr[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }



        Arrays.stream(tempArr).forEach(System.out::println);

        /*for(int x = i, v=0; i<= j-i; x++,v++){
            input[x] = tempArr[v];
        }*/

    }


    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
//        System.out.println("----------------");
//        Arrays.stream(temp).forEach(System.out::println);

        System.arraycopy(input, i, input, start + tempIndex, mid - i);


        System.arraycopy(temp, 0, input, start, tempIndex);


    }

}
