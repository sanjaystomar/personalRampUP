package org.personal.rampup.problemSolving;

public class MagicPotion {
    public static void main(String[] args) {
        String str1 = "ABCDABCE";
        String str2 = "ABCABCE";
        String str3 = "AAAAAA";
        String str4 = "AAAABBBB";
        String str5 = "ABABCABABCD";
        String str6 = null;

        System.out.println(findMinSteps(str1));
        System.out.println(findMinSteps(str2));
        System.out.println(findMinSteps(str3));
        System.out.println(findMinSteps(str4));
        System.out.println(findMinSteps(str5));
        System.out.println(findMinSteps(str6));
    }

    private static int findMinSteps(String str) {
        if(str==null)
            throw new IllegalArgumentException("Provided string can't be null!!");
        int length = str.length();
        if(length==0)
            return 0;

        int [] tempArray = new int[length];
        for(int i=0; i<length; i++){
            tempArray[i] = Integer.MAX_VALUE;
        }

        tempArray[0] = 1;
        for (int j = 1; j < length; j++){
            tempArray[j] = Math.min(tempArray[j], tempArray[j-1]+1);

            if(2*j+1 < length && (str.substring(0,j+1).equals(str.substring(j+1, 2*j+2)))){
                tempArray[2*j+1] = tempArray[j]+1;
            }
        }
        return tempArray[length-1];
    }
}
