package org.personal.rampup.problemSolving;


public class OptimalPath {
    public static void main(String[] args) {
        int inputArray1[][] = {
                {1, 3, 2, 0, 2, 1, 8},
                {3, 4, 1, 2, 0, 1, 1},
                {1, 1, 1, 2, 3, 2, 1},
                {1, 0, 1, 1, 4, 2, 1}
        };

        int inputArray2[][] = {{0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}};
        int inputArray3[][] = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int inputArray4[][] = {{1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}};
        int inputArray5[][] = {{}, {}};
        int inputArray6[][] = null;

        int result1 = calulateOptimalPath(inputArray1);
      /*  int result2 = calulateOptimalPath(inputArray2);
        int result3 = calulateOptimalPath(inputArray3);
        int result4 = calulateOptimalPath(inputArray4);
        int result5 = calulateOptimalPath(inputArray5);
        try {
            int result6 = calulateOptimalPath(inputArray6);
            System.out.println(result6);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }*/

        System.out.println(result1);
       /* System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);*/


    }

    private static int calulateOptimalPath(int[][] inputArray) {
        if (inputArray == null || inputArray[0] == null)
            throw new IllegalArgumentException("All the dimensions are mandatory to use the function!!");

        int rows = inputArray.length - 1;
        int columns = inputArray[0].length - 1;
        if (rows < 1 || columns < 1)
            return 0;

        for (int i = rows; i >= 0; i--) {
            for (int j = 0; j <= columns; j++) {
                if (i < rows && j > 0) {
                    inputArray[i][j] += Math.max(inputArray[i + 1][j], inputArray[i][j - 1]);
                    System.out.println("at i &  :" + i +"|"+ j + "value is :" + inputArray[i][j] );
                } else if (i < rows) {
                    inputArray[i][j] += inputArray[i + 1][j];
                    System.out.println("at i & j :" + i +"|"+ j + "value is :" + inputArray[i][j] );
                } else if (j > 0) {
                    inputArray[i][j] += inputArray[i][j - 1];
                    System.out.println("at i & j :" + i +"|"+ j + "value is :" + inputArray[i][j] );
                }
            }
        }
        return inputArray[0][columns];
    }
}
