package org.personal.rampup.collections.custom;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildMaxHeap {
    public static int[] maxHeapArray = new int[8];
    public static int[] minHeapArray = new int[8];

    public static void main(String[] args) {
        int[] array1 = {98, 3, 7, 2, 1, 19, 9, 8};
        for (int i = 0; i < array1.length; i++) {
            constructMaxHeap(array1[i], i);
            constructMinHeap(array1[i], i);
        }
        System.out.print("MaxHeapArray : ");
        printArray(maxHeapArray);
        System.out.println();
        System.out.print("MinHeapArray : ");
        printArray(minHeapArray);
        System.out.println();

        System.out.print("MaxHeapArray Deletion : ");
        printArray(removeElementMxHeap());
        System.out.println();
        System.out.print("MinHeapArray Deletion : ");
        printArray(removeElementMnHeap());
        System.out.println();

    }

    public static void constructMaxHeap(int element, int index) {
        maxHeapArray[index] = element;
        if (maxHeapArray[index] > maxHeapArray[(index - 1) / 2]) {
            maxHeapy(index, maxHeapArray);
        }
    }


    public static void maxHeapy(int index, int[] arr) {
        for (int i = index; i > 0; i--) {
            int parentNode = (i - 1) / 2;
            if (arr[i] > arr[parentNode]) {
                swap(i, parentNode, arr);
            }
        }
    }


    public static void constructMinHeap(int element, int index) {
        minHeapArray[index] = element;
        if (minHeapArray[index] > minHeapArray[(index - 1) / 2]) {
            minHeapy(index, minHeapArray);
        }
    }

    public static void minHeapy(int index, int[] arr) {
        for (int i = index; i > 0; i--) {
            int parentNode = (i - 1) / 2;
            if (arr[i] < arr[parentNode]) {
                swap(i, parentNode, arr);
            }
        }
    }


    public static int[] removeElementMxHeap() {

        int elementRemoved = maxHeapArray[0];
        maxHeapArray[0] = maxHeapArray[maxHeapArray.length - 1];
        int[] tempMaxHeapArray = new int[maxHeapArray.length - 1];
        System.arraycopy(maxHeapArray, 0, tempMaxHeapArray, 0, maxHeapArray.length - 1);
        for (int i = 0; i < maxHeapArray.length - 1; i++) {
            int lt = 2 * i + 1;
            int rt = 2 * i + 2;
            if (rt < tempMaxHeapArray.length) {
                if (tempMaxHeapArray[i] < tempMaxHeapArray[lt]) {
                    maxHeapy(lt, tempMaxHeapArray);
                } else if (tempMaxHeapArray[i] < tempMaxHeapArray[rt]) {
                    maxHeapy(rt, tempMaxHeapArray);
                }
            }
        }
        System.out.println("###########Element removed : " + elementRemoved); //todo Find a way to return the element back for the call and the functionality should not break!!
        return tempMaxHeapArray;
    }

    public static int[] removeElementMnHeap() {
        int elementRemoved = minHeapArray[0];
        minHeapArray[0] = minHeapArray[minHeapArray.length - 1];
        int[] tempMinHeapArray = new int[minHeapArray.length - 1];
        System.arraycopy(minHeapArray, 0, tempMinHeapArray, 0, minHeapArray.length - 1);
        for (int i = 0; i < minHeapArray.length - 1; i++) {
            int lt = 2 * i + 1;
            int rt = 2 * i + 2;
            if (rt < tempMinHeapArray.length) {
                if (tempMinHeapArray[i] > tempMinHeapArray[lt]) {
                    minHeapy(lt, tempMinHeapArray);
                } else if (tempMinHeapArray[i] > tempMinHeapArray[rt]) {
                    minHeapy(rt, tempMinHeapArray);
                }
            }
        }
        System.out.println("###########Element removed : " + elementRemoved); //todo Find a way to return the element back for the call and the functionality should not break!!
        return tempMinHeapArray;

    }
























    /*public static void main(String[] args) {
        int[] array1 = {0, 3, 7, 2, 1, 19, 9, 8};
        printArray(array1);
        buildHeap(array1, array1.length - 1, true);
        System.out.println();
        printArray(array1);
        insertElement(array1, 20);

        System.out.println("------------------");
        printArray(array1);
        buildHeap(array1, array1.length - 1, false);
        System.out.println();
        printArray(array1);
    }*/

    public static void buildHeap(int[] arr, int n, boolean isMaxHeap) {
        for (int k = n / 2 + 1; k >= 0; k--) {
            if (isMaxHeap)
                maxHeapify(arr, k, n);
            else
                minHeapify(arr, k, n);
        }
    }

    public static void insertElement(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[newArr.length - 1] = element;
        buildHeap(newArr, newArr.length - 1, true);
        System.out.println();
        printArray(newArr);
    }

    public static void maxHeapify(int[] arr, int i, int n) {
        int lt = 2 * i + 1;
        int rt = 2 * i + 2;
        int largest = 0;
        if (lt <= n && arr[lt] > arr[i]) {
            largest = lt;
        } else largest = i;

        if (rt <= n && arr[rt] > arr[largest]) {
            largest = rt;
        }

        if (largest != i) {
            swap(largest, i, arr);
            if (2 * largest + 2 <= n) {
                maxHeapify(arr, largest, n);
            }
        }

    }

    public static void minHeapify(int[] arr, int i, int n) {
        int lt = 2 * i + 1;
        int rt = 2 * i + 2;
        int smallest = 0;

        if (lt <= n && arr[lt] < arr[i]) {
            smallest = lt;
        } else
            smallest = i;
        if (rt <= n && arr[rt] < arr[smallest]) {
            smallest = rt;
        }

        if (smallest != i) {
            swap(smallest, i, arr);
            if (2 * smallest + 2 <= n) {
                minHeapify(arr, smallest, n);
            }
        }


    }

    public static void swap(int in1, int in2, int[] arr) {
        int temp = arr[in2];
        arr[in2] = arr[in1];
        arr[in1] = temp;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
