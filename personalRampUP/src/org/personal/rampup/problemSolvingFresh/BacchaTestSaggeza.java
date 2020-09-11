package org.personal.rampup.problemSolvingFresh;

public class BacchaTestSaggeza {


    public static void main(String[] args) {
        System.out.println(getNoOfSwaps("ntiin"));

    }


    /**
     * Algorithm:
     *     1. First check the given string is a jumbled/shuffled palindrome or not.
     *     2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start iterating.
     *     3. If chars at both the pointers are same then just shrink the window (increase the p1 and decrease the p2).
     *     4. or Else
     *          a. find the matching pair and swap the char to p2 index (increase swap count while swapping) and finally shrink the window.
     *          b. if not found just swap once with adjacent index and increase the swap count (do not shrink the window here)
     *     5. Print the Swap Count
     *
     * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration * O(n) for checking and swapping ] so => O(n^2)
     * Space Complexity: O(n)
     *
     */
    private static  int getNoOfSwaps(String input1) {
        if(input1 == null || input1.length() == 0) return -1;
        int swapCounts = 0;

        if(isJumbledString(input1)) {
            char[] chars = input1.toCharArray();
            int pointer1 = 0, pointer2 = chars.length - 1;

            while(pointer2 > pointer1) {
                if(chars[pointer1] != chars[pointer2]) {
                    int k = pointer2;
                    while(k > pointer1 && chars[k] != chars[pointer1]) k--;

                    if(k == pointer1) { //When no matching character found
                        swapTheChars(chars, pointer1, pointer1 + 1);
                        swapCounts++;

                    } else { //When Matching character found swap until K reaches p2 position
                        while(k < pointer2) {
                            swapTheChars(chars, k, k + 1);
                            swapCounts++;
                            k++;
                        }
                        pointer1++; pointer2--;
                    }
                } else {
                    pointer1++; pointer2--; //When the characters are equal move on
                }
            }
            return swapCounts;
        }
        else return -1;
    }

    private static void swapTheChars(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static boolean isJumbledString(String s) {
        int [] occurrence = new int[26];
        int oddCount = 0;

        for(int i = 0; i < s.length(); i++) occurrence[s.charAt(i) - 'a']++;
        for (int value : occurrence) if (value % 2 != 0) oddCount++;
        return oddCount <= 1;
    }
}

