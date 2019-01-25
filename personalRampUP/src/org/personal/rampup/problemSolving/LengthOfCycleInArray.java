package org.personal.rampup.problemSolving;

public class LengthOfCycleInArray {

    public static void main(String[] args) {
        runTest();
    }

    public static void runTest() {
        try {
            int[] inputArray = {0, 1, 3, 4, 9, 4, 4, 4, 0, 0}; // {0,3,4,9,4,4,4,0}
            int index = 10;
            calcuateCycle(inputArray, index);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int calcuateCycle(int[] inputArray, int startIndex) {
        if(startIndex > inputArray.length)
            throw new IllegalArgumentException("index should be less than the array Size!!");


        return 0;
    }
}
