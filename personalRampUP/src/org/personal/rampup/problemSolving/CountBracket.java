package org.personal.rampup.problemSolving;

import java.util.Stack;

/*
Find the maximum number of valid consecutive braces. A valid brace is ().  )()()((((())()()()()() Count in this case is 5  ()()((()()()(()) Count in this case is 3
*/
public class CountBracket {
    public static void main(String[] args) {
        System.out.println(countValidParenthesis(")()()((((())()()()()()"));
        System.out.println(countValidParenthesis("()()((()()()(())"));

    }

   /* public static int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 1;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }*/

    public static int countValidParenthesis(String inputString) {
        int maxCount = 0;
        int count = 0;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ')') {
                if (inputString.charAt(i - 1) == '(') {
                    count++;
                    if (count > maxCount) maxCount = count;
                } else {
                    count = 0;
                }
            } else if (i + 1 < inputString.length() && inputString.charAt(i) == '(' && inputString.charAt(i + 1) == '(') {
                count = 0;
            }
        }
        return maxCount;
    }
}
