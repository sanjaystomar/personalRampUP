package org.personal.rampup.problemSolvingFresh;

/*
 ** Instructions to candidate.
 **  1) Given an array of non-negative integers representing the elevations
 **     from the vertical cross section of a range of hills, determine how
 **     many units of snow could be captured between the hills.
 **
 **     See the example array and elevation map below.
 **                                 ___
 **             ___                |   |        ___
 **            |   |        ___    |   |___    |   |
 **         ___|   |    ___|   |   |   |   |   |   |
 **     ___|___|___|___|___|___|___|___|___|___|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **                                 ___
 **             ___                |   |        ___
 **            |   | *   *  _*_  * |   |_*_  * |   |
 **         ___|   | *  _*_|   | * |   |   | * |   |
 **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **
 **     Solution: In this example 13 units of snow (*) could be captured.
 **
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement computeSnowpack() correctly.
 */
public class SnowPack {

    /*
     **  Find the amount of snow that could be captured.
     */
//    public static Integer computeSnowpack(Integer[] arr)
    public static Integer computeSnowpack(int[] snowLines) {
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

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
//    public static boolean doTestsPass()
//    {
//        boolean result = true;
//        result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
//
//        return result;
//    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
//        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
//        else
        {
            System.out.println("Tests fail.");
        }
    }
}
