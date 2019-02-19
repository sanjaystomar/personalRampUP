package org.personal.rampup.hackerRank.basics;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Map<Integer, String> daysOfWeek = new HashMap<>();
        daysOfWeek.put(1,"SUNDAY");
        daysOfWeek.put(2,"MONDAY");
        daysOfWeek.put(3,"TUESDAY");
        daysOfWeek.put(4,"WEDNESDAY");
        daysOfWeek.put(5,"THURSDAY");
        daysOfWeek.put(6,"FRIDAY");
        daysOfWeek.put(7,"SATURDAY");
        Calendar cal = Calendar.getInstance();
        // months are form 0-11 hence month-1
        cal.set(year,month-1,day);
        return daysOfWeek.get(cal.get(Calendar.DAY_OF_WEEK));
    }

}

public class CalendarSolution {
    public static void main(String[] args) throws IOException {
   /*     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);
*/
//        String res = Result.findDay(month, day, year);
        String res = Result.findDay(7, 05, 2015);

      /*  bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

