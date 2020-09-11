package org.personal.rampup.random;

// JAVA program to count number of changes
// to make all substrings distinct.
import java.lang.*;
import java.util.*;

class GFG
{
    static final int MAX_CHAR = 26;

    // Returns minimum changes to str so
    // that no substring is repeated.
    public static int minChanges(String str)
    {

        int length = str.length();

        // If length is more than maximum

        // allowed characters, we cannot
        // get the required string.
        if (length > MAX_CHAR)
            return -1;

        // Variable to store count of
        // distinct characters
        int dist_count = 0;
        int count[] = new int[MAX_CHAR];

        // To store counts of different
        // characters
        for(int i = 0; i < MAX_CHAR; i++)
            count[i] = 0;

        for (int i = 0; i < length; i++)
        {
            if(count[str.charAt(i)-'a'] == 0)
                dist_count++;
            count[str.charAt(i)-'a']++;
        }

        // Answer is, length - number of distinct char
        return (length-dist_count);
    }

    //Driver function
    public static void main (String[] args) {

        //String str = "aebaecedabbee";
//        String str = "abab";
        String str = "abcabc";

        System.out.println(minChanges(str));
    }
}

/* This code is contributed by Akash Singh*/
