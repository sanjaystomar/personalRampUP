package org.personal.rampup.problemSolving;

public class SnowPack {

    public static void main(String[] args) {
        int[] snowLines1 = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        int[] snowLines2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] snowLines3 = {3, 0, 0, 2, 0, 4};
        System.out.println(calculateSnow(snowLines1));
        System.out.println(calculateSnow(snowLines2));
        System.out.println(calculateSnow(snowLines3));
    }

    public static int calculateSnow(int[] snowLines) {
        int low = 0, high = snowLines.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalSnow = 0;
        while (low <= high) {
            if (snowLines[low] < snowLines[high]) {
                if (snowLines[low] > leftMax) {
                    leftMax = snowLines[low];
                } else {
                    totalSnow += leftMax - snowLines[low];
                    low++;
                }
            } else {
                if (snowLines[high] > rightMax) {
                    rightMax = snowLines[high];
                } else {
                    totalSnow += rightMax - snowLines[high];
                    high--;
                }
            }
        }
        return totalSnow;
    }
}
