package org.personal.rampup.problemSolving;

public class SecondSmallest {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {0};
        int[] c = {0, 1};
        int[] d = {-1, 0, 1, -2, 2};
        int[] e = {1, 1, 2};
        int[] f = {Integer.MAX_VALUE};
        System.out.println(findSecSmallest(a));
        System.out.println(findSecSmallest(b));
        System.out.println(findSecSmallest(c));
        System.out.println(findSecSmallest(d));
        System.out.println(findSecSmallest(e));
        System.out.println(findSecSmallest(f));
    }

    public static int findSecSmallest(int[] inputArrray) {
        if (inputArrray.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for (int i = 0; i < inputArrray.length; i++) {
            if (inputArrray[i] < min) {
                secMin = min;
                min = inputArrray[i];
            } else if (inputArrray[i] < secMin && inputArrray[i] != min) {
                secMin = inputArrray[i];
            }
        }
        return secMin;
    }
}
