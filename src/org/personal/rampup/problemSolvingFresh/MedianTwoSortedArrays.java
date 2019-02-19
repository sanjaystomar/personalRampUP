package org.personal.rampup.problemSolvingFresh;

public class MedianTwoSortedArrays {
    private static double logic(int[] A, int[] B) {
        return -1.0;
        //your code
    }

    public static boolean pass()
    {
        boolean result = true;
        result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        return result;
    };

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("some failures");
        }
    }
}
